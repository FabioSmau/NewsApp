package com.news.newsdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.data.repository.NewsRepository
import com.news.models.ARTICLE_ID_ARG
import com.news.models.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsDetailViewModel(
    private val repository: NewsRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _uiState = MutableStateFlow(NewsDetailState())
    val uiState: StateFlow<NewsDetailState> = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(NewsDetailViewModel::class.java.name, throwable.message ?: "")

    }

    init {
        getArticleById()
    }
    fun getArticleById() {
        startLoadingState()
        viewModelScope.launch(coroutineDispatcher + coroutineExceptionHandler) {
            val article = repository.getLastNews()?.articles?.firstOrNull { it.title == getArticleIdentifier() }
            withContext(Dispatchers.Main) {
                if (article != null) {
                    onLoadedArticleWithSuccess(article)
                } else {
                    onError()
                }
            }
        }
    }

    private fun getArticleIdentifier(): String? {
        return savedStateHandle.get<String>(ARTICLE_ID_ARG)
    }

    private fun startLoadingState() {
        _uiState.value = _uiState.value.copy(loading = true)
    }

    private fun onLoadedArticleWithSuccess(article: Article) {
        _uiState.value = _uiState.value.copy(loading = false, article = article)
    }

    private fun onError() {
        _uiState.value = _uiState.value.copy(loading = false, error = true)
    }
}