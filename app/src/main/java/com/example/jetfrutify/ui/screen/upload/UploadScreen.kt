package com.example.jetfrutify.ui.screen.upload


import android.Manifest
import android.graphics.BitmapFactory
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetfrutify.R
import com.example.jetfrutify.ui.navigation.Screen
import com.example.jetfrutify.ui.theme.DarkBlue
import com.example.jetfrutify.ui.theme.JetFrutifyTheme
import com.example.jetfrutify.util.rotateFile
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun UploadScreen(
    navController: NavHostController
) {
    val cameraPermissionState: PermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    val context = LocalContext.current

    var getFile: File? = null
    var filename: String? = null
    var quality: String? = null
    var fruitId: Int = 1
    var idFruit: Int = 0
    var path: String? = null

//    val product = intent.getParcelableExtra<ProductItem>("product")
//    val fromHomeSeller = intent.getBooleanExtra("from_home_seller", false)
//    val fromBtnDelete = intent.getBooleanExtra("from_btn_delete", false)
//    val fruitId = product?.FRUITID

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val dataProduct = navBackStackEntry?.savedStateHandle?.get<String>("EXTRA_FILENAME")
    dataProduct.let { filename = it }
    val dataQuality = navBackStackEntry?.savedStateHandle?.get<String>("EXTRA_QUALITY")
    dataQuality.let { quality = it }
    val myFile = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        navBackStackEntry?.savedStateHandle?.get<File>("picture")
    } else {
        @Suppress("DEPRECATION")
        (navBackStackEntry?.savedStateHandle?.get<File>("picture"))
    }
    val isBackCamera = navBackStackEntry?.savedStateHandle?.get<Boolean>("isBackCamera") ?: true
//    myFile?.let { file ->
//        rotateFile(file, isBackCamera)
//        getFile = file
//
//    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray, shape = RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(5.dp))
                .clickable {
                    if (cameraPermissionState.status.isGranted) {
                        navController.navigate(Screen.Camera.route)
                    } else {
                        Toast
                            .makeText(context, "unpermisssion", Toast.LENGTH_SHORT)
                            .show()
                        cameraPermissionState.launchPermissionRequest()
                    }
                }
        ) {
            if (myFile != null) {
                myFile.let { file ->
                    rotateFile(file, isBackCamera)
                    getFile = file
                    val bitmap = BitmapFactory.decodeFile(file.path)
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "add image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            } else {
                val defaultImage = painterResource(id = R.drawable.camera)
                Image(
                    painter = defaultImage,
                    contentDescription = "default image",
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f)
                        .padding(bottom = 10.dp)
                )
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 20.dp)
        ) {
            ButtonFresh(title = "Segar", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(5.dp))
            ButtonFresh(title = "Busuk", modifier = Modifier.weight(1f))
        }
        TextFieldUpload(title = "Fruit",icon = Icons.Default.Create ,value = "", onValueChange = {})
        Spacer(modifier = Modifier.size(5.dp))
        TextFieldUpload(title = "Name", icon = Icons.Default.Create, value = "", onValueChange = {})
        Spacer(modifier = Modifier.size(5.dp))
        TextFieldUpload(title = "Description", icon = Icons.Default.List, value = "", onValueChange = {}, modifier = Modifier.height(250.dp))
        Spacer(modifier = Modifier.size(5.dp))
        TextFieldUpload(title = "Price", icon = Icons.Default.List, value = "", onValueChange = {})

        Spacer(modifier = Modifier.size(10.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = DarkBlue, CircleShape)
        ) {
            Text(text = "Submit")
        }

    }
}

@Composable
fun ButtonFresh(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(25.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color(0xFF9F9F9F), shape = RoundedCornerShape(5.dp))
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.25.sp,
            ),
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 2.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldUpload(
    title: String,
    icon: ImageVector,
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                letterSpacing = 0.25.sp,
            )
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = modifier
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .border(width = 1.dp, color = DarkBlue, shape = RoundedCornerShape(5.dp))
        )
    }

}

@Preview(showBackground = true)
@Composable
fun upload() {

    JetFrutifyTheme {
        UploadScreen(navController = rememberNavController())
    }

}