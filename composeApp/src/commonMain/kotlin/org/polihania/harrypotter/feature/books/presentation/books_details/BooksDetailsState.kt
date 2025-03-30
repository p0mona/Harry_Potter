package org.polihania.harrypotter.feature.books.presentation.books_details

import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.books.domain.model.BookModel

data class BooksDetailsState(
    val book: Data<BookModel> = Data.Empty
)