package com.example.jetfrutify.ui.screen.auth

import androidx.lifecycle.ViewModel
import com.example.jetfrutify.data.repository.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RoleViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel(){

    fun saveRole(roleValue: String) = runBlocking {
        repository.saveRole(roleValue)
    }

}