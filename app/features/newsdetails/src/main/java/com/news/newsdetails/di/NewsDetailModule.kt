package com.news.newsdetails.di

import com.news.newsdetails.NewsDetailViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailModule = module {
    factory { Dispatchers.IO }
    viewModel { NewsDetailViewModel(get(), get(), get()) }
}
