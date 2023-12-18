package com.news.network.di

import com.news.network.apis.NewsAPI
import com.news.network.providers.OkHttpSettings
import com.news.network.providers.RetrofitSettings
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

const val baseUrl = "https://newsapi.org"

val networkModule = module {

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return RetrofitSettings(baseUrl, client).provide()
    }

    fun provideHttpClient(): OkHttpClient {
        return OkHttpSettings().provide()
    }

    fun provideNewsAPI(retrofit: Retrofit): NewsAPI = retrofit.create(NewsAPI::class.java)

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
    factory { provideNewsAPI(get()) }
}