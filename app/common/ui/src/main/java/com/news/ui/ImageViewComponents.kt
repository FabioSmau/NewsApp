package com.news.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImageViewAsync(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        modifier = modifier,
        contentDescription = null,
        placeholder = BrushPainter(
            Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.onPrimary,
                    MaterialTheme.colorScheme.onSecondary,
                )
            )
        ),
        contentScale = ContentScale.Inside,
    )
}