package com.example.jetfrutify.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetfrutify.ui.theme.DarkBlue
import com.example.jetfrutify.ui.theme.JetFrutifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldAuth(
    value: String,
    label: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(
            text = label,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            color = Color(0xFF626262),
            fontWeight = FontWeight(500),
        ) },
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight(500),
        ),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Email"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .border(
                width = 2.dp,
                color = DarkBlue,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .fillMaxWidth()
            .background(
                color = Color(0xFFF1F4FF),
                shape = RoundedCornerShape(10.dp)
            )

    )
}

@Preview(showBackground = true)
@Composable
fun previewT() {
    JetFrutifyTheme {
        TextFieldAuth(value = "", label = "email", icon = Icons.Default.Email,onValueChange = {})
    }

}