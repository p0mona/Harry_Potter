package org.polihania.harrypotter.feature.books.domain.model

data class BookModel(
    val cover: String,
    val description: String,
    val index: Int,
    val number: Int,
    val pages: Int,
    val releaseDate: String,
    val title: String
)