package com.news.data.repository

import com.news.models.Article
import com.news.models.News


class NewsMockRepository : NewsRepository {
    override suspend fun getLastNews(): News {
        return News(
            totalResults = 1,
            articles = listOf(
                Article(
                    author = "autor",
                    title = "Noticia 1",
                    description = "Descrição da noticia 1",
                    url = "url da noticia",
                    urlToImage = "url da imagem da noticia",
                    publishedAt = "data da publicação da noticia",
                    content = "conteudo"
                ),
            )
        )
    }
}