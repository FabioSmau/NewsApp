package com.news.data.repository

import com.news.data.model.News

interface NewsRepository {
    suspend fun getLastNews(): List<News>
}