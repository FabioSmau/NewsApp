package com.news.newsdetails

import com.news.models.Article

data class NewsDetailState(
    var loading: Boolean = false,
    val article: Article? = null,
    val error: Boolean = false
)