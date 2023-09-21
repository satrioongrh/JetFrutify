package com.example.jetfrutify.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonAuth (
    text: String,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .shadow(
                elevation = 3.dp,
                spotColor = Color(0xFFCBD6FF),
                ambientColor = Color(0xFFCBD6FF),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .background(color = Color(0xFF1F41BB), shape = RoundedCornerShape(size = 10.dp))
        ) {
        Text(text = text, style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
        ))
    }
}