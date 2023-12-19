package com.news.data.repository

import com.news.models.Article
import com.news.models.News


class NewsMockRepository : NewsRepository {
    override suspend fun getLastNews(): News? {
        return News(
            totalResults = 1,
            articles = listOf(
                Article(
                    author = "autor 1",
                    title = "Noticia 1",
                    description = "Descrição da noticia 1",
                    url = "url da noticia 1",
                    urlToImage = "url da imagem da noticia 1",
                    publishedAt = "data da publicação da noticia 1",
                    content = "conteudo 1"
                ),
                Article(
                    author = "autor 2",
                    title = "Noticia 2",
                    description = "Descrição da noticia 2",
                    url = "url da noticia 2",
                    urlToImage = "url da imagem da noticia 2",
                    publishedAt = "data da publicação da noticia 2",
                    content = "conteudo 2"
                ),
                Article(
                    author = "autor 3",
                    title = "Noticia 3",
                    description = "Descrição da noticia 3",
                    url = "url da noticia 3",
                    urlToImage = "url da imagem da noticia 3",
                    publishedAt = "data da publicação da noticia 3",
                    content = "conteudo 3"
                )
            )
        )
    }
}