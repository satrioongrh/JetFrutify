package com.example.jetfrutify.ui.screen.auth.login

import androidx.lifecycle.ViewModel
import com.example.jetfrutify.data.repository.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    fun doLogin(email: String, password: String) = repository.doLogin(email, password)

//    fun doLogin(email: String, password: String) {
//        Log.d("LoginViewModel", "doLogin called with email: $email, password: $password")
//        viewModelScope.launch {
//            val response = repository.doLogin(email, password)
//            when (response) {
//                is Result.Success -> {
//                    _loginResult.value = response.data
//                }
//                is Result.Error -> {
//                    error.value = response.error
//                }
//                else -> {}
//            }
//        }
//    }

//    fun doRegister(
//        email: String,
//        password: String,
//        phone: String,
//        role: String
//    ) {
//        viewModelScope.launch {
//            repository.doRegister(email, password, phone, role)
//        }
//    }
}