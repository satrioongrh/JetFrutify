package com.example.jetfrutify.ui.screen.auth.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetfrutify.R

@Composable
fun BackgroundTopSection () {
    Image(
        painter = painterResource(id = R.drawable.elipse),
        contentDescription = null,
        modifier = Modifier
            .offset(x = 50.dp, y = (-220).dp)
            .width(635.dp)
            .height(635.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.elipse2),
        contentDescription = null,
        modifier = Modifier
            .offset(x = 10.dp, y = (-120).dp)
            .width(496.dp)
            .height(496.dp)
    )
}