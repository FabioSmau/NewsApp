package com.news.newslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.data.model.News
import com.news.data.repository.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsListViewModel(
    private val repository: NewsRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var _uiState = MutableStateFlow(NewsListState())
    val uiState: StateFlow<NewsListState> = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(NewsListViewModel::class.java.name, throwable.message ?: "")
        _uiState.value = _uiState.value.copy(loading = false, news = emptyList(), error = true)
    }

    init {
        getNews()
    }

    fun getNews() {
        startLoadingState()
        viewModelScope.launch(coroutineDispatcher + coroutineExceptionHandler) {
            val news = repository.getLastNews()
            withContext(Dispatchers.Main) {
                onLoadedNewsWithSuccess(news)
            }
        }
    }

    private fun startLoadingState() {
        _uiState.value = _uiState.value.copy(loading = true)
    }

    private fun onLoadedNewsWithSuccess(news: List<News>) {
        _uiState.value = _uiState.value.copy(loading = false, news = news)
    }
}

