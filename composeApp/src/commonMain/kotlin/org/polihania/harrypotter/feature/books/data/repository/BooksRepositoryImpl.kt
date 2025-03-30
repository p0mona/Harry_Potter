package org.polihania.harrypotter.feature.books.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.map
import org.polihania.harrypotter.feature.books.data.api.BooksApi
import org.polihania.harrypotter.feature.books.data.dto.toModel
import org.polihania.harrypotter.feature.books.data.dto.toModelList
import org.polihania.harrypotter.feature.books.domain.model.BookModel
import org.polihania.harrypotter.feature.books.domain.repository.BooksRepository

class BooksRepositoryImpl(
    private val api: BooksApi
) : BooksRepository {

    override fun getBooksList(): Flow<Data<List<BookModel>>> {
        return api.getBooks().map {
            it.map { data ->
                data.toModelList()
            }
        }
    }

    override fun searchBook(query: String): Flow<Data<List<BookModel>>> {
        return api.getBooks(search = query).map {
            it.map { data ->
                data.toModelList()
            }
        }
    }

    override fun getBookById(id: Int): Flow<Data<BookModel>> {
        return api.getBookById(index = id).map {
            it.map { data ->
                data.toModel()
            }
        }
    }
}