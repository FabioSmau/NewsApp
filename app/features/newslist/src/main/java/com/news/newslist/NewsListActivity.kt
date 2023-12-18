package com.news.newslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListActivity : ComponentActivity() {

    private val newsViewModel by viewModel<NewsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsListScreen(newsViewModel)
        }
    }


}

