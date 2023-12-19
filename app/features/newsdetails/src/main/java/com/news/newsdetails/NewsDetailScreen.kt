package com.news.newsdetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsDetailScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    newsDetailViewModel: NewsDetailViewModel = koinViewModel(),
) {
    val state by newsDetailViewModel.uiState.collectAsState()
    CreateViewByArticle(modifier)
}

@Composable
private fun CreateViewByArticle(modifier: Modifier) {
    Text(text = "TESTE")
}


