package com.example.jetfrutify.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetfrutify.R
import com.example.jetfrutify.ui.theme.JetFrutifyTheme

@Composable
fun Logo (){
    Image(
        painter = painterResource(id = R.drawable.frutifylogo),
        contentDescription = stringResource(
            R.string.logo_frutify
        ),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(220.dp)
    )
}

@Preview
@Composable
fun preview() {
    JetFrutifyTheme {
        Logo()
    }
}