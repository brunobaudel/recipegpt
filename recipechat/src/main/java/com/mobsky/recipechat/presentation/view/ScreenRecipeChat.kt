package com.mobsky.recipechat.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenRecipe(texto: String){
    Column{
        Text(text = texto)
        Text(text = texto)
    }

}

@Preview
@Composable
fun PreviewScreenRecipe() {
    ScreenRecipe("Android")
}