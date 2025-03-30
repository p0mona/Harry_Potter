package org.polihania.harrypotter.feature.books.presentation.books_list

import androidx.compose.runtime.Stable
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.books.domain.model.BookModel

@Stable
data class BooksListState(
    val books: Data<List<BookModel>> = Data.Empty
)