package com.news.ui

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CircularLoading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
    )
}