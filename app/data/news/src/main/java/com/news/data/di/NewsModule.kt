package com.news.data.di

import com.news.data.repository.NewsRemoteRepository
import com.news.data.repository.NewsRepository
import com.news.network.di.networkModule
import org.koin.dsl.module

val repositoryNews = module {
    factory <NewsRepository> { NewsRemoteRepository(get()) }
}