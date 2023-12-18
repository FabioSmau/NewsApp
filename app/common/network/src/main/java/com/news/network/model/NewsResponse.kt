package com.news.network.model

import com.news.models.News

data class NewsResponse (
    val totalResults: Int,
    val articles: List<ArticleData>
)

fun NewsResponse.toNews(): News {
    return News(
        totalResults = totalResults,
        articles = articles.map { it.toArticle() }
    )
}