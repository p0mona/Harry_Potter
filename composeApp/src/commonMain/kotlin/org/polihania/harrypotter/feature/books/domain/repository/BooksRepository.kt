package org.polihania.harrypotter.feature.books.domain.repository

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.books.domain.model.BookModel

interface BooksRepository {

    fun getBooksList(): Flow<Data<List<BookModel>>>

    fun getBookById(id: Int): Flow<Data<BookModel>>
}