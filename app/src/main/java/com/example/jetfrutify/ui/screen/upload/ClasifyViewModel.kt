package com.example.jetfrutify.ui.screen.upload

import androidx.lifecycle.ViewModel
import com.example.jetfrutify.data.repository.remote.RemoteClasifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ClasifyViewModel @Inject constructor(
    private val repository: RemoteClasifyRepository
) : ViewModel() {

    fun predictImage(image: File) = repository.predictImage(image)

}