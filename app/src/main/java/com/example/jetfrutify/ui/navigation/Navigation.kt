package com.example.jetfrutify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetfrutify.ui.screen.auth.RoleScreen
import com.example.jetfrutify.ui.screen.auth.login.LoginScreen
import com.example.jetfrutify.ui.screen.auth.login.LoginViewModel
import com.example.jetfrutify.ui.screen.auth.register.RegisterScreen
import com.example.jetfrutify.ui.screen.auth.register.RegisterViewModel
import com.example.jetfrutify.ui.screen.home.HomeScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = hiltViewModel()
    val registerViewModel: RegisterViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screen.Role.route){
        composable(Screen.Role.route){
            RoleScreen(navController = navController)
        }
        composable(Screen.Login.route){
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController, viewModel = registerViewModel)
        }
    }
}