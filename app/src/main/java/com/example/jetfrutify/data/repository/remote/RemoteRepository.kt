package com.example.jetfrutify.data.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.jetfrutify.data.datastore.Datastore
import com.example.jetfrutify.data.response.LoginResponse
import com.example.jetfrutify.data.response.RegisterResponse
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.data.retrofit.ApiService
import com.example.jetfrutify.util.Constant
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class RemoteRepository @Inject constructor(
    private val apiService: ApiService,
    private val dataStore: Datastore
) {

    private val loginResult = MediatorLiveData<Result<LoginResponse>>()
    private val registerResult = MediatorLiveData<Result<RegisterResponse>>()

    fun doLogin(email: String, password: String): LiveData<Result<LoginResponse>> {
        val client = apiService.doLogin(email, password)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val resp = response.body()
                if (resp?.sTATUS == "SUCCESS") {
                    loginResult.value = Result.Success(resp)
                    dataStore.apply {
                        runBlocking {
                            putInt(
                                Constant.PREF_USER_ID,
                                resp.pAYLOAD?.user?.uSERID ?: 0
                            )
                            putString(
                                Constant.PREF_EMAIL,
                                resp.pAYLOAD?.user?.uSEREMAIL ?: ""
                            )
                            putString(
                                Constant.PREF_USER_PHONE,
                                resp.pAYLOAD?.user?.uSERPHONE ?: ""
                            )
                            putString(
                                Constant.PREF_USER_FULLNAME,
                                resp.pAYLOAD?.user?.uSERFULLNAME ?: ""
                            )
                            putString(
                                Constant.PREF_USER_ROLE,
                                resp.pAYLOAD?.user?.uSERROLE ?: ""
                            )
                            putString(
                                Constant.PREF_USER_ADDRESS,
                                resp.pAYLOAD?.user?.uSERADDRESS ?: ""
                            )

                        }
                    }
                } else {
                    loginResult.value =
                        Result.Error("Login failed. Please check your email and/or password.")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResult.value = Result.Error(t.message.toString())
            }

        })
        return loginResult
    }

    fun doRegister(
        email: String,
        password: String,
        phone: String,
        role: String
    ): LiveData<Result<RegisterResponse>> {
        val client = apiService.doRegister(email, password, phone, role)
        client.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                val resp = response.body()
                if (resp?.sTATUS == "SUCCESS") {
                    registerResult.value = Result.Success(resp)
                } else {
                    val error = resp?.mESSAGE ?: "an unknown error occurred"
                    registerResult.value = Result.Error(error)
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                registerResult.value = Result.Error(t.message.toString())
            }
        })
        return registerResult
    }

    suspend fun saveRole(roleValue: String) = dataStore.putString(Constant.PREF_USER_ROLE, roleValue)

    suspend fun getRole() = dataStore.getString(Constant.PREF_USER_ROLE)

//    fun doLogin(email: String, password: String) : Result<LoginResponse> {
//        Log.d("TAGerr", "doLogin: terpanggil repo")
//        val response = try {
//            apiService.doLogin(email, password)
//        } catch (e: Exception) {
//            return Result.Error("an unknown error")
//        }
//        Log.d("TAGerr", "doLogindeae: $response")
//
//        return Result.Success(response)
//    }
//
//    suspend fun doRegister(
//        email: String,
//        password: String,
//        phone: String,
//        role: String
//    ) : Result<RegisterResponse> {
//        val response = try {
//            apiService.doRegister(email, password, phone, role)
//        } catch (e: Exception) {
//            return Result.Error("an unknown error")
//        }
//        return Result.Success(response)
//    }

}