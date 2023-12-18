package com.news.app

import android.app.Application
import com.news.data.di.repositoryNews
import com.news.network.di.networkModule
import com.news.newslist.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AppNewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppNewsApplication)
            modules(
                repositoryNews,
                networkModule,
                newsModule
            )
        }
    }
}