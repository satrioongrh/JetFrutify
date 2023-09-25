package com.example.jetfrutify.data.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.jetfrutify.data.datastore.Datastore
import com.example.jetfrutify.data.response.productresponse.ListProductResponse
import com.example.jetfrutify.data.response.productresponse.ProductItem
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.data.retrofit.ApiService
import com.example.jetfrutify.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteProductRepository @Inject constructor(
    private val api: ApiService,
    private val dataStore: Datastore
) {

    private val resultProduct = MediatorLiveData<Result<List<ProductItem?>?>>()

    suspend fun getProduct(
        search: String? = null,
    ) : LiveData<Result<List<ProductItem?>?>> {
        val roleUser = dataStore.getString(Constant.PREF_USER_ROLE)
        var userId: Int? = null
        if (roleUser == "SELLER"){
            userId = dataStore.getInt(Constant.PREF_USER_ID)
        }
        val client = api.getListProduct(search, userId)
        client.enqueue(object : Callback<ListProductResponse> {
            override fun onResponse(
                call: Call<ListProductResponse>,
                response: Response<ListProductResponse>
            ) {
                if (response.isSuccessful) {
                    val listProductResponse = response.body()
                    val products = listProductResponse?.pAYLOAD?.product
                    resultProduct.value = Result.Success(products)
                }
            }

            override fun onFailure(call: Call<ListProductResponse>, t: Throwable) {
                resultProduct.value = Result.Error(t.message.toString())
            }
        })
        return resultProduct
    }
}