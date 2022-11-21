package com.example.libretranslateandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.toSize
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
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.quicksand_bold)
                ),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            DropDownMenu()
            TranslateBox()
            DropDownMenu()
            TranslatedBox()
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(Gray800),
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Translate button",
                    tint = Color.White,
                    modifier = Modifier
                        .size(ButtonDefaults.IconSize)
                    )
            }
        }
    }
}

@Composable
fun TranslateBox() {
    Column {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {newText ->
            text = newText },
            placeholder = { Text(
                text = "Type to translate",
                fontSize = 25.sp) },
            maxLines = 10,
            textStyle = TextStyle(color = Color.White, fontSize = 25.sp),
            modifier = Modifier
                .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray800,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
        )
    }
}

@Composable
fun TranslatedBox() {
    Column {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {newText ->
                text = newText },
            maxLines = 10,
            placeholder = { Text(
                text = "Translation",
                fontSize = 25.sp) },
            textStyle = TextStyle(color = Color.White, fontSize = 25.sp),
            modifier = Modifier
                .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray800,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            readOnly = true,
        )
    }
}

@Composable
fun DropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val list = listOf("English", "Spanish", "Japanese")
    var selectedItem by remember { mutableStateOf("") }

    var textFiledSize by remember { mutableStateOf(Size.Zero) }

    val icon = if(expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(8.dp)) {
        
        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(
                text = "Select Language",
                color = Color.White,
            ) },
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Gray800,
                unfocusedBorderColor = Gray800,
            )
        )
        
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}