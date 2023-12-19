package com.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderView(title: String?, url: String?, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(8.dp)
    val height = 240.dp
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(White, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        ImageViewAsync(
            url ?: "",
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )
        Text(
            text = title ?: "",
            color = Color.LightGray,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            style = MaterialTheme.typography.titleLarge,
        )

    }
}
//@Composable
//fun HeaderView(title: String?, url: String?, modifier: Modifier = Modifier) {
//
//    Box(modifier = modifier) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .wrapContentHeight()
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            ImageViewAsync(
//                url ?: "",
//                Modifier
//                    .width(72.dp)
//                    .height(72.dp)
//                    .padding(horizontal = 8.dp)
//            )
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .wrapContentHeight()
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = title ?: "",
//                    style = MaterialTheme.typography.headlineLarge,
//                )
//            }
//        }
//    }
//}

@Preview
@Composable
fun HeaderViewPreview() {
    HeaderView("Titulo", "")
}