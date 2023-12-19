package com.news.models

import java.util.UUID

const val ARTICLE_ID_ARG = "article_id"

data class Article(
    val author: String? = "",
    val title: String? = "",
    val description: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String? = "",
    val content: String? = ""
)