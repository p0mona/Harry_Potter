package org.polihania.harrypotter.feature.books.data.api

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.data.HttpClientProvider
import org.polihania.harrypotter.core.data.fetchDataWithQuery
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.books.data.dto.BookDto

class BooksApi(
    clientProvider: HttpClientProvider
) {
    private val client = clientProvider.getClient()

    fun getBooks(
        max: Int? = null,
        page: Int? = null,
        search: String? = null
    ): Flow<Data<List<BookDto>>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "books",
            index = null,
            max = max,
            page = page,
            search = search
        )
    }

    fun getBookById(
        index: Int
    ): Flow<Data<BookDto>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "books",
            index = index,
            max = null,
            page = null,
            search = null
        )
    }
}