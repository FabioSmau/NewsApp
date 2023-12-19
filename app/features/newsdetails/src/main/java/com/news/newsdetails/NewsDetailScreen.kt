package com.news.newsdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.news.models.Article
import com.news.ui.CircularLoading
import com.news.ui.HeaderView
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    newsDetailViewModel: NewsDetailViewModel = koinViewModel(),
) {
    val state by newsDetailViewModel.uiState.collectAsState()
    CreateViewByArticle(state, modifier)
}

@Composable
private fun CreateViewByArticle(state: NewsDetailState, modifier: Modifier) {
    if (state.loading) {
        CreateLoading(modifier)
        return
    }
    if (state.error || state.article == null) {
        CreateEmptyState(modifier)
        return
    }
    CreateNewsDetails(state.article, modifier)
}

@Composable
private fun CreateLoading(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        CircularLoading()
    }
}

@Composable
private fun CreateEmptyState(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Text(text = "Error to load details of news!")
    }
}

@Composable
private fun CreateNewsDetails(article: Article?, modifier: Modifier) {
    Column(Modifier.fillMaxSize()) {
        HeaderView(title = article?.title, url = article?.urlToImage)
        ContentNewsList(article)
    }
}

@Composable
private fun ContentNewsList(article: Article?) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        article?.let { article ->
            items(article.getArticleInfo()) { info ->
                Text(text = info.orEmpty())
            }
        }
    }
}


