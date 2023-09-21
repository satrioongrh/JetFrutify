package com.example.jetfrutify.ui.screen.auth.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.ui.component.ButtonAuth
import com.example.jetfrutify.ui.component.HeadlineAuth
import com.example.jetfrutify.ui.component.Logo
import com.example.jetfrutify.ui.component.TextFieldAuth
import com.example.jetfrutify.ui.navigation.Screen
import com.example.jetfrutify.ui.screen.auth.section.BackgroundTopSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val lifecycleowner = LocalLifecycleOwner.current

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
            Logo()
            HeadlineAuth(text = "Login Here")
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldAuth(
                value = email,
                label = "email",
                icon = Icons.Default.Email,
                onValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldAuth(
                value = password,
                label = "password",
                icon = Icons.Default.Lock,
                onValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            ButtonAuth(text = "Sign In", onCLick = {
                val loginResult = viewModel.doLogin(email, password)
                loginResult.observe(lifecycleowner){
                    if (it is Result.Success){
                        navController.navigate(Screen.Home.route)
                    } else {
                        Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Create new account",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF494949),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.Register.route)
                    }
            )
        }
    }


//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        TextField(value = valueEmail, onValueChange = { valueEmail = it })
//        TextField(value = valuePassword, onValueChange = { valuePassword = it })
//        Button(onClick = {
//            val result = viewModel.doLogin(valueEmail, valuePassword)
//            result.observe(lifecycleowner){
//                if (it is Result.Success){
//                    navController.navigate(Screen.Home.route)
//                } else  {
//                    Toast.makeText(context, "${it}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }) {
//            Text(text = "login")
//        }
//
//    }

}