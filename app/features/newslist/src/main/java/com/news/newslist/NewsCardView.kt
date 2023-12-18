package com.news.newslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.news.models.Article
import com.news.ui.ImageViewAsync


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(article: Article, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Card(modifier = modifier, onClick = onClick) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageViewAsync(
                article.urlToImage ?: "",
                Modifier
                    .width(72.dp)
                    .height(72.dp)
                    .padding(horizontal = 8.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = article.title ?: "",
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}

@Preview
@Composable
fun CatInfoPreview() {
    NewsCard(
        Article(title = "Titulo")
    )
}