package com.news.newslist

import com.news.data.repository.NewsMockRepository
import com.news.data.repository.NewsRepository
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
class NewsListViewModelTest {
    private var repository: NewsRepository = mockk(relaxed = true)
    private lateinit var viewModel: NewsListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = NewsListViewModel(repository, Dispatchers.Main)
    }

    @Test
    fun `When reposity return news with success`() {
        runTest {
            coEvery { repository.getLastNews() } returns NewsMockRepository().getLastNews()
            viewModel.getNews()
            assert(viewModel.uiState.value.news != null)
            assert(viewModel.uiState.value.news?.articles?.size == 3)
            assert(!viewModel.uiState.value.loading)
            assert(!viewModel.uiState.value.error)
        }
    }

    @Test
    fun `When reposity return news with null news object`() {
        runTest {
            coEvery { repository.getLastNews() } returns null
            viewModel.getNews()
            assert(viewModel.uiState.value.news == null)
            assert(!viewModel.uiState.value.loading)
            assert(!viewModel.uiState.value.error)
        }
    }
}