package com.news.data.repository

import com.news.models.News

class NewsCachedRepository(private val repository: NewsRepository) : NewsRepository {

    private var cachedNews: News? = null
    override suspend fun getLastNews(): News? {
        if (cachedNews == null) {
            val news = repository.getLastNews()
            cachedNews = news
        }
        return cachedNews
    }
}