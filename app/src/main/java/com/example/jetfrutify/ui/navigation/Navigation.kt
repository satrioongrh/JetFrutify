package com.example.jetfrutify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetfrutify.ui.screen.auth.RoleScreen
import com.example.jetfrutify.ui.screen.auth.RoleViewModel
import com.example.jetfrutify.ui.screen.auth.login.LoginScreen
import com.example.jetfrutify.ui.screen.auth.login.LoginViewModel
import com.example.jetfrutify.ui.screen.auth.register.RegisterScreen
import com.example.jetfrutify.ui.screen.auth.register.RegisterViewModel
import com.example.jetfrutify.ui.screen.cart.CartScreen
import com.example.jetfrutify.ui.screen.home.HomeScreen
import com.example.jetfrutify.ui.screen.home.HomeViewModel
import com.example.jetfrutify.ui.screen.home.seller.HomeSellerScreen
import com.example.jetfrutify.ui.screen.profile.ProfileScreen

@Composable
fun Navigation (navController: NavHostController) {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val registerViewModel: RegisterViewModel = hiltViewModel()
    val roleViewModel: RoleViewModel = hiltViewModel()
    val homeViewModel: HomeViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screen.Role.route){
        composable(Screen.Role.route){
            RoleScreen(navController = navController, viewModel = roleViewModel)
        }
        composable(Screen.Login.route){
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }
        composable(Screen.Home.route){
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController, viewModel = registerViewModel)
        }
        composable(Screen.HomeBottomBar.route){
            HomeSellerScreen(navController = navController, viewModel = homeViewModel)
        }
        composable(Screen.Cart.route){
            CartScreen()
        }
        composable(Screen.Profile.route){
            ProfileScreen()
        }
    }
}