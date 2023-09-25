package com.example.jetfrutify.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {
    Column (modifier = Modifier.fillMaxSize()) {
        Text(text = "hello")
    }
    viewModel.getProduct()
}