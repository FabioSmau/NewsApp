package com.news.newslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class NewsListActivity : ComponentActivity() {

    //private val viewModel: NewsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //NewsCardView().CardNews(News("Teste", "Descr"), {})
        }
    }
}

