package com.news.newslist.di

import com.news.newslist.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {
    viewModel { NewsListViewModel(get()) }
}
