package com.example.libretranslateandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.plcoding.meditationuiyoutube.ui.theme.Gray800
import com.plcoding.meditationuiyoutube.ui.theme.Gray900

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(Gray900)
        .fillMaxSize()
    ) {
        Column {
            Text(
                text = "Libre Translate",
                fontSize = 45.sp,
                color = Color.White,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            TextBox()
            TextBox()
        }
    }
}

@Composable
fun TextBox() {
    Column {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {newText ->
            text = newText },
            maxLines = 10,
            textStyle = TextStyle(color = Color.White, fontSize = 25.sp),
            modifier = Modifier
                .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray800,
            )

        )
    }
}