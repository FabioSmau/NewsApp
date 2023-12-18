package com.news.data.repository

import com.news.models.News
import com.news.network.apis.NewsAPI
import com.news.network.model.toNews

class NewsRemoteRepository(private val api: NewsAPI): NewsRepository {
    override suspend fun getLastNews(): News {
        val result = api.getNews()
        return result.toNews()
    }
}
