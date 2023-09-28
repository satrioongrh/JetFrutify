package com.example.jetfrutify.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetfrutify.ui.screen.home.HomeViewModel
import com.example.jetfrutify.ui.theme.DarkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchbar(
    value: String,
    onValueChange: (String) -> Unit = {},
    viewModel: HomeViewModel
) {
    Box(
        modifier = Modifier
    ) {
        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .fillMaxWidth()
                .shadow(5.dp, shape = RoundedCornerShape(15.dp))
                .background(Color(0xFFF2F3F2), shape = RoundedCornerShape(15.dp))
                .border(width = 2.dp, color = DarkBlue),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    modifier = Modifier
                        .clickable {
                            viewModel.getProduct(value)
                        }
                )
            },
            placeholder = { Text(text = "Search...") },

            )
    }
}