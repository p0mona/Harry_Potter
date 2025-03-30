package org.polihania.harrypotter.feature.books.data.dto

import kotlinx.serialization.Serializable
import org.polihania.harrypotter.core.utils.orZero
import org.polihania.harrypotter.feature.books.domain.model.BookModel

@Serializable
data class BookDto(
    val cover: String? = null, // Cover image url
    val description: String? = null,
    val index: Int? = null, // Book id
    val number: Int? = null, // Book number
    val originalTitle: String? = null, // Same as title
    val pages: Int? = null, // Number of book pages
    val releaseDate: String? = null,
    val title: String? = null
)

fun BookDto.toModel() = BookModel(
    index = index.orZero(),
    number = number.orZero(),
    pages = pages.orZero(),
    cover = cover.orEmpty(),
    description = description.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    title = title.orEmpty()
)

fun List<BookDto>.toModelList() = map { it.toModel() }
