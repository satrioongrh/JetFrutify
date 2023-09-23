package com.example.jetfrutify

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetfrutify.ui.component.BottomBar
import com.example.jetfrutify.ui.navigation.Navigation
import com.example.jetfrutify.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrutifyApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Role.route &&
                currentRoute != Screen.Login.route &&
                currentRoute != Screen.Register.route
            ) {
                BottomBar(navController)
            }
        }
    ) {
        Navigation(navController)
    }
}