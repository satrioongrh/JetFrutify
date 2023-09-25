package com.example.jetfrutify.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ButtonFruit(
    val title: String,
    val imageVector: Painter,
    val background: Color
)

@Composable
fun ButtonCategoryFruit(
    title: String,
    image: Painter,
    background: Color
) {
    Column(modifier = Modifier.height(99.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(73.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = background)
        ) {
            Image(
                painter = image,
                contentDescription = title,
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF06161C),
                textAlign = TextAlign.Center,
            )
        )
    }
}