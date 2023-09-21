package com.example.jetfrutify.ui.screen.auth.register

import androidx.lifecycle.ViewModel
import com.example.jetfrutify.data.repository.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    fun doRegister(
        email: String,
        password: String,
        phone: String,
        role: String
    ) = repository.doRegister(email, password, phone, role)

    fun getRole() = runBlocking {
        repository.getRole()
    }

}