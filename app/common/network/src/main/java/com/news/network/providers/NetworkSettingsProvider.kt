package com.news.network.providers

interface NetworkSettingsProvider<T> {
    fun provide(): T
}