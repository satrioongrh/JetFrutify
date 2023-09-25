package com.example.jetfrutify.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetfrutify.R
import com.example.jetfrutify.ui.navigation.Screen
import com.example.jetfrutify.ui.screen.auth.section.BackgroundTopSection
import com.example.jetfrutify.ui.theme.DarkBlue

@Composable
fun RoleScreen(
    navController: NavHostController,
    viewModel: RoleViewModel
) {
    val isLogin = viewModel.isLogin()
    if (isLogin == true){
        navController.navigate(Screen.Home.route)
    }
    Log.d("fead", "RoleScreen: $isLogin")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(31.dp)
            .background(color = Color(0xFFFFFFFF))
    ) {
        BackgroundTopSection()
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wfh),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 70.dp, top = 20.dp)
                    .width(363.dp)
                    .height(370.dp)
            )
            Text(
                text = "Find the best fruit for you",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1F41BB),
                    textAlign = TextAlign.Center
                ),
            )
            Spacer(modifier = Modifier.height(23.dp))
            Text(
                text = "Explore all the existing job roles based on your interest and study major",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                ),
            )
            Text(
                text = "Login / Register as",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 20.dp)
            )
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                ButtonRole(
                    text = "Buyer",
                    textColor = Color(0xFFFFFFFF),
                    color = DarkBlue,
                    onCLick = {
                        viewModel.saveRole("Buyer")
                        navController.navigate(Screen.Login.route){
                            popUpTo(Screen.Role.route){
                                inclusive = true
                            }
                        }
                    }
                )
                ButtonRole(
                    text = "Seller",
                    textColor = Color.Black,
                    color = Color(0xFFFFFFFF),
                    onCLick = {
                        viewModel.saveRole("Seller")
                        navController.navigate(Screen.Register.route)
                    }
                )
            }

        }
    }
}

@Composable
fun ButtonRole(
    text: String,
    textColor: Color,
    color: Color,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0xFFCBD6FF),
                ambientColor = Color(0xFFCBD6FF)
            )
            .width(160.dp)
            .height(60.dp)
            .background(color = color, shape = RoundedCornerShape(size = 10.dp))
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                color = textColor,
                textAlign = TextAlign.Center,
            )
        )
    }
}