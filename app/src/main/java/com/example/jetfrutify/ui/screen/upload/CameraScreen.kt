package com.example.jetfrutify.ui.screen.upload

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.util.createFile
import com.example.jetfrutify.util.rotateBitmap
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import java.io.FileOutputStream

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
    navController: NavHostController,
    viewModel: ClasifyViewModel
) {

    val context = LocalContext.current
    val lifecycleowner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                PreviewView(context).apply {
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    setBackgroundColor(Color.BLACK)
                    scaleType = PreviewView.ScaleType.FILL_START
                }.also { previewView ->
                    previewView.controller = cameraController
                    cameraController.bindToLifecycle(lifecycleowner)
                }
            }
        )
        Button(
            onClick = {
                takePhoto(
                    context = context,
                    cameraController = cameraController,
                    viewModel = viewModel,
                    lifecycleOwner = lifecycleowner,
                    navController = navController
                )
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "klik")
        }
    }
}

private fun takePhoto(
    context: Context,
    cameraController: LifecycleCameraController,
    viewModel: ClasifyViewModel,
    lifecycleOwner: LifecycleOwner,
    navController: NavHostController
) {
    val application: Application = context.applicationContext as Application
    val photoFile = createFile(application = application)
    var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
    cameraController.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onError(exc: ImageCaptureException) {
                Toast.makeText(
                    context,
                    "Gagal mengambil gambar.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                val rotatedBitmap = rotateBitmap(
                    BitmapFactory.decodeFile(photoFile.path),
                    cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA
                )
                val rotatedFile = createTempFile("rotated_", ".jpg", context.cacheDir)
                rotatedFile.deleteOnExit()
                val outputStream = FileOutputStream(rotatedFile)
                rotatedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                outputStream.close()

                val result = viewModel.predictImage(rotatedFile)
                result.observe(lifecycleOwner) { imageClasifyResponse ->
                    if (imageClasifyResponse is Result.Success) {
                        val filename = imageClasifyResponse.data.pAYLOAD?.filename.toString()
                        val quality = imageClasifyResponse.data.pAYLOAD?.quality.toString()
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "EXTRA_FILENAME",
                            filename
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "EXTRA_QUALITY",
                            quality
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "picture",
                            photoFile
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "isBackCamera",
                            cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA
                        )
                        navController.popBackStack()
                    }
                }
            }
        }
    )
}

