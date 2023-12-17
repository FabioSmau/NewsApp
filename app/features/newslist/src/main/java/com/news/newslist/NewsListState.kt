package com.news.newslist

import com.news.data.model.News
data class NewsListState(
    var loading: Boolean = false,
    val news: List<News> = emptyList(),
    val error: Boolean = false
)