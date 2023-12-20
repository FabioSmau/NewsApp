package com.news.network

import com.news.network.di.networkModule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import retrofit2.Retrofit

@RunWith(JUnit4::class)

class RetrofitClientTests : KoinTest {

    private val retrofit: Retrofit by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(networkModule)
    }

    @Test
    fun `test if URL from retrofit instance is correct`() {
        assert(retrofit.baseUrl().toString() == "https://newsapi.org/")
    }
}