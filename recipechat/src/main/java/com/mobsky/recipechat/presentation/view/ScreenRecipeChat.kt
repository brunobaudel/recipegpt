package com.mobsky.recipechat.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenRecipe() {

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
            Text(text = "teste")
        }

        EditTags("bruno")
    }
}

data class Item(val name: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTags(texto: String) {

    var text by remember { mutableStateOf(TextFieldValue("")) }
    var listTags by remember { mutableStateOf(listOf("Tag1", "tag2")) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            listTags.forEach {
                Tag(text = it)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier.weight(1f)
            )
            Button(
                modifier = Modifier.padding(start = 10.dp),
                onClick = {
                    listTags = listTags.toMutableList().apply {
                        add(text.text)
                    }
                }
            ) {
                Text("ok")
            }
        }
    }
}

@Composable
fun Tag(text: String, borderColor: Color = Color.Red, isBorder: Boolean = true) {

    val modifierTag = if (isBorder) {
        Modifier
            .padding(2.dp)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(5.dp))
            .padding(2.dp)
    } else {
        Modifier
    }

    Text(text = text, modifier = modifierTag)
}

@Preview
@Composable
fun PreviewScreenRecipe() {
    ScreenRecipe()
}