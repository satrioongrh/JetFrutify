package com.example.jetfrutify.ui.screen.home.seller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetfrutify.R
import com.example.jetfrutify.data.responsehandler.Result
import com.example.jetfrutify.ui.component.ButtonCategoryFruit
import com.example.jetfrutify.ui.component.ButtonFruit
import com.example.jetfrutify.ui.component.CardFruitSeller
import com.example.jetfrutify.ui.component.Searchbar
import com.example.jetfrutify.ui.screen.home.HomeViewModel

@Composable
fun HomeSellerScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    val listIconFruit = listOf(
        ButtonFruit(
            "Apples",
            painterResource(id = R.drawable.appleicon),
            Color(0xFFFFCBCB)
        ),
        ButtonFruit(
            "Bananas",
            painterResource(id = R.drawable.bananaicon),
            Color(0xFFF6E7AC)
        ),
        ButtonFruit(
            "Oranges",
            painterResource(id = R.drawable.orangeicon),
            Color(0xFFFFD7A4)
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var searchbarValue by remember { mutableStateOf("") }
        Searchbar(
            value = searchbarValue,
            onValueChange = {
                searchbarValue = it
            },
            viewModel = viewModel
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Categories",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF06161C),
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            listIconFruit.forEach { fruit ->
                ButtonCategoryFruit(
                    title = fruit.title,
                    image = fruit.imageVector,
                    background = fruit.background
                )
            }
        }
        val fruits = viewModel.getProduct()
        LazyVerticalGrid(columns = GridCells.Adaptive(128.dp)) {
            fruits.observe(lifecycleOwner) { result ->
                if (result is Result.Success) {
                    result.data?.let { productList ->
                        items(productList) { productItem ->
                            CardFruitSeller(
                                title = productItem?.pRODUCTNAME ?: "",
                                price = productItem?.pRODUCTPRICE ?: 0,
                                image = productItem?.pRODUCTFILEPATH!!
                            )
                        }
                    }
                }
            }
        }
    }
}

