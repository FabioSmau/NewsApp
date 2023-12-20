package com.news.app.di

import com.news.data.di.repositoryNews
import com.news.network.di.networkModule
import com.news.newsdetails.di.newsDetailModule
import com.news.newslist.di.newsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        repositoryNews,
        networkModule,
        newsModule,
        newsDetailModule
    )
}