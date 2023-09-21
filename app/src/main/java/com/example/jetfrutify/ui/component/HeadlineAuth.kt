package com.example.jetfrutify.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.jetfrutify.ui.theme.DarkBlue

@Composable
fun HeadlineAuth(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight(700),
            color = DarkBlue,
            textAlign = TextAlign.Center
        )
    )
}