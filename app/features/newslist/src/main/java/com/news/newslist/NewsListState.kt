package com.news.newslist

import com.news.models.News

data class NewsListState(
    var loading: Boolean = false,
    val news: News? = null,
    val error: Boolean = false
)