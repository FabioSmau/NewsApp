package com.news.newsdetails

import androidx.lifecycle.SavedStateHandle
import com.news.data.repository.NewsMockRepository
import com.news.data.repository.NewsRepository
import com.news.models.ARTICLE_ID_ARG
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NewsDetailViewModelTest {
    private var repository: NewsRepository = mockk(relaxed = true)
    private lateinit var viewModel: NewsDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = NewsDetailViewModel(repository, createSavedStateWithArg(), Dispatchers.Main)
    }

    private fun createSavedStateWithArg(): SavedStateHandle {
        return SavedStateHandle().apply {
            set(ARTICLE_ID_ARG, "Noticia 2")
        }
    }

    @Test
    fun `When reposity return news with success get the select article`() {
        runTest {
            coEvery { repository.getLastNews() } returns NewsMockRepository().getLastNews()
            viewModel.getArticleById()
            assert(viewModel.uiState.value.article != null)
            assert(viewModel.uiState.value.article?.title == "Noticia 2")
            assert(!viewModel.uiState.value.loading)
            assert(!viewModel.uiState.value.error)
        }
    }

    @Test
    fun `When reposity return null on search article by id must error state`() {
        runTest {
            coEvery { repository.getLastNews() } returns null
            viewModel.getArticleById()
            assert(viewModel.uiState.value.article == null)
            assert(!viewModel.uiState.value.loading)
            assert(viewModel.uiState.value.error)
        }
    }

}