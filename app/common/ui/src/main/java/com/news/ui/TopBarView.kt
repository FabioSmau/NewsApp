package com.news.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithBackButton(title: String, upAvailable: Boolean, onUpClicked: () -> Unit) {
    TopAppBar(title = { Text(text = title) }, navigationIcon = {
        if (upAvailable) {
            IconButton(onClick = { onUpClicked() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
            }
        }
    })
}