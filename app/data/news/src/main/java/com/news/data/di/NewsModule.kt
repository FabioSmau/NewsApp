package com.news.data.di

import com.news.data.repository.NewsRemoteRepository
import com.news.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryNews = module {
    factory <NewsRepository> { NewsRemoteRepository(get()) }
}