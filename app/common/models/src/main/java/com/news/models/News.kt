package com.news.models

data class News(
    val totalResults: Int,
    val articles: List<Article>
) {
    companion object {
        fun createEmptyNews() = News(0, listOf())
    }
}