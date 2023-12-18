package com.news.data.repository

import com.news.models.News

interface NewsRepository {
    suspend fun getLastNews(): News
}