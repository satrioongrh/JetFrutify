package com.example.jetfrutify.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetfrutify.ui.navigation.Screen

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val screen: Screen
)

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    NavigationBar(
        containerColor = Color(0xFFFFFFFF),
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color(0x80C6CDD8),
                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )
            .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unSelectedIcon = Icons.Outlined.Home,
                screen = Screen.HomeBottomBar
            ),
            NavigationItem(
                title = "Cart",
                selectedIcon = Icons.Filled.ShoppingCart,
                unSelectedIcon = Icons.Outlined.ShoppingCart,
                screen = Screen.Cart
            ),
            NavigationItem(
                title = "Profile",
                selectedIcon = Icons.Filled.Person,
                unSelectedIcon = Icons.Outlined.Person,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (currentRoute == item.screen.route) item.selectedIcon else item.unSelectedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}