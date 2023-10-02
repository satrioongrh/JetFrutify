package com.example.jetfrutify.data.repository.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.jetfrutify.data.response.clasifyresponse.PredictResponse
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.data.retrofit.ApiService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class RemoteClasifyRepository @Inject constructor(
    private val apiService: ApiService
) {

    private val resultPredict = MediatorLiveData<Result<PredictResponse>>()

    fun predictImage(image: File) : LiveData<Result<PredictResponse>>{

        val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), image)
        val imagePart = MultipartBody.Part.createFormData("image", image.name, requestFile)

        val client = apiService.doImagePredict(imagePart)
        client.enqueue(object : Callback<PredictResponse>{
            override fun onResponse(
                call: Call<PredictResponse>,
                response: Response<PredictResponse>
            ) {
                val imagePredictResponse = response.body()
                if (imagePredictResponse != null){
                    resultPredict.value = Result.Success(imagePredictResponse)
                } else {
                    Log.d(TAG, "onResponse: not found")
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                resultPredict.value = Result.Error(t.message.toString())
            }

        })
        return resultPredict
    }

    companion object {
        private const val TAG = "ClasifyViewModel"
    }

}