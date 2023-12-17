package com.news.newslist

import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.news.data.model.News

class NewsCardView {

    @Composable
    fun CardNewsList(newsList: List<News>) {
        newsList.forEach { news ->
            CardNews(news, {

            })
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CardNews(
        news: News,
        onClick: () -> Unit
    ) {
        Card(
            onClick = { onClick() },
            modifier = Modifier.size(width = 180.dp, height = 100.dp)
        ) {
            Box(Modifier.fillMaxSize()) {
                Text("Titulo: " + news.title, Modifier.align(Alignment.Center))
            }
        }
    }

    @Composable
    fun CardNews2(
        news: News,
        onClick: () -> Unit
    ) {
        val padding = 16.dp
        Column(
            Modifier
                .clickable(onClick = onClick)
                .padding(padding)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) { /*...*/ }
            Spacer(Modifier.size(padding))
            Card(elevation = CardDefaults.cardElevation(8.dp)) { /*...*/ }
        }
    }
}