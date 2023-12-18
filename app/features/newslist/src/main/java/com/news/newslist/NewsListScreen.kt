package com.news.newslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.news.models.News
import com.news.ui.CircularLoading

@Composable
fun NewsListScreen(
    newsListViewModel: NewsListViewModel,
    //navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by newsListViewModel.uiState.collectAsState()
    createViewByState(state, modifier)
}

@Composable
private fun createViewByState(state: NewsListState, modifier: Modifier) {
    if (state.loading) {
        createLoading(modifier)
        return
    }
    if (state.error || state.news.articles.isEmpty()) {
        createError(modifier)
        return
    }
    createNews(state.news)
}
@Composable
private fun createLoading(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        CircularLoading()
    }
}

@Composable
private fun createError(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        CircularLoading()
    }
}

@Composable
private fun createNews(news: News) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(news.articles) { article ->
            NewsCard(article, onClick = { })
        }
    }
}