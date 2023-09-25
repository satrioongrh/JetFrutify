package com.example.jetfrutify.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.jetfrutify.data.repository.remote.RemoteProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RemoteProductRepository
) : ViewModel() {

    fun getProduct(search: String? = null) = runBlocking {
        repository.getProduct(search)
    }


}