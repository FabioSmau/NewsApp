package com.news.data.repository

import com.news.data.model.News

class NewsMockRepository: NewsRepository {
    override suspend fun getLastNews(): List<News> {
        return listOf(
            News("Noticia 1", "Descrição da noticia 1"),
            News("Noticia 2", "Descrição da noticia 2"),
            News("Noticia 3", "Descrição da noticia 3"),
            News("Noticia 4", "Descrição da noticia 4"),
            News("Noticia 5", "Descrição da noticia 5"),
        )
    }
}