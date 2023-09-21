package com.example.jetfrutify.ui.navigation

sealed class Screen (val route: String) {
    object Role : Screen("role")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
}