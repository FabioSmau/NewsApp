package com.news.newsdetails.di

import com.news.newsdetails.NewsDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailModule = module {
    viewModel { NewsDetailViewModel(get(), get()) }
}
