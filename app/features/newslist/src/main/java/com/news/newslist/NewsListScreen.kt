package com.news.newslist

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.navigation.NavHostController
import com.news.models.ARTICLE_ID_ARG
import com.news.models.News
import com.news.ui.CircularLoading
import com.news.utils.navigate
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsListScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    newsListViewModel: NewsListViewModel = koinViewModel(),
) {
    val state by newsListViewModel.uiState.collectAsState()
    CreateViewByState(state, modifier, navController)
}

@Composable
private fun CreateViewByState(
    state: NewsListState,
    modifier: Modifier,
    navController: NavHostController
) {
    if (state.loading) {
        CreateLoading(modifier)
        return
    }
    if (state.error || state.news?.articles?.isEmpty() == true) {
        CreateEmptyState(modifier)
        return
    }
    CreateNews(state.news, navController)
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
        Text(text = "List news is empty")
    }
}

@Composable
private fun CreateNews(news: News?, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        news?.let {
            items(it.articles) { article ->
                val bundle = Bundle().apply { putString(ARTICLE_ID_ARG, article.title) }
                NewsCard(article, onClick = { navController.navigate("list", args = bundle) })
            }
        }
    }
}
