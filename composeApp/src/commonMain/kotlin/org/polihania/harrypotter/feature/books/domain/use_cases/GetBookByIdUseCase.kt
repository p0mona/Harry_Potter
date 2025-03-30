package org.polihania.harrypotter.feature.books.domain.use_cases

import org.polihania.harrypotter.feature.books.domain.repository.BooksRepository

class GetBookByIdUseCase(
    private val repository: BooksRepository
) {
    operator fun invoke(bookId: Int) = repository.getBookById(bookId)
}