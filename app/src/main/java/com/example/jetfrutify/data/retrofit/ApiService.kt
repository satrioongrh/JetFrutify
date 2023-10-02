package com.example.jetfrutify.data.retrofit

import com.example.jetfrutify.data.response.authresponse.LoginResponse
import com.example.jetfrutify.data.response.authresponse.RegisterResponse
import com.example.jetfrutify.data.response.clasifyresponse.PredictResponse
import com.example.jetfrutify.data.response.productresponse.ListProductResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @POST("auth/login")
    @FormUrlEncoded
    fun doLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<LoginResponse>

    @POST("auth/register")
    @FormUrlEncoded
    fun doRegister(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
        @Field("role") role: String
    ) : Call<RegisterResponse>

    @POST("product/list")
    @FormUrlEncoded
    fun getListProduct(
        @Field("search") search: String? = null,
        @Field("user_id") userId: Int? = null
    ) : Call<ListProductResponse>

    @Multipart
    @POST("fruit/classify")
    fun doImagePredict(
        @Part image: MultipartBody.Part
    ): Call<PredictResponse>

}