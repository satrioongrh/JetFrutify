package com.example.jetfrutify.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetfrutify.R
import com.example.jetfrutify.util.Constant

@Composable
fun CardFruitSeller(
    title: String,
    price: Int,
    image: String,
) {
    Card(
        shape = RoundedCornerShape(18.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .shadow(
                    elevation = 12.dp,
                    spotColor = Color(0x00000000),
                    ambientColor = Color(0x00000000)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xB253B175),
                    shape = RoundedCornerShape(size = 18.dp)
                )
                .width(174.5.dp)
                .height(185.dp)
                .background(color = Color(0x1A53B175), shape = RoundedCornerShape(size = 18.dp))
                .padding(top = 4.dp, start = 4.dp, end = 4.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(Constant.BASE_URL_3 + image)
                    .crossfade(true)
                    .build()
                ,
                placeholder = painterResource(R.drawable.appleicon),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(3.dp)
                    .height(111.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 18.dp, topStart = 18.dp))
            )
            Spacer(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xB253B175))
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF181725),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.1.sp,
                    ),
                )
                Text(
                    text = price.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF181725),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.1.sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(
                    text = "edit",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .weight(1f)
                        .border(
                            1.dp,
                            Color(0xB253B175),
                            shape = RoundedCornerShape(bottomStart = 18.dp)
                        )
                )
                Text(
                    text = "delete",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .weight(1f)
                        .border(
                            1.dp,
                            Color(0xB2FE6E6E),
                            shape = RoundedCornerShape(bottomEnd = 18.dp)
                        )
                        .background(
                            Color(0xB2FF9999),
                            shape = RoundedCornerShape(bottomEnd = 18.dp)
                        )
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun cardpref() {
//    JetFrutifyTheme {
//        CardFruitSeller(title = "apel", price = 19000, image = )
//    }
//
//}