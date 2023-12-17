package com.news.data.di

import com.news.data.repository.NewsMockRepository
import com.news.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryNews = module {
    //includes(network)
    factory <NewsRepository> { NewsMockRepository() }
}