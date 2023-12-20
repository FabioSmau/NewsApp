package com.news.newslist.di

import com.news.newslist.NewsListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {
    viewModel { NewsListViewModel(get(), get()) }
    factory { Dispatchers.IO }
}
