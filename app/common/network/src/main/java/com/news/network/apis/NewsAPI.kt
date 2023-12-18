package com.news.network.apis

import com.news.network.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("/v2/everything")
    fun getNews(
        @Query("q") sources: String? = "bitcoin",
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 50
    ): NewsResponse
}