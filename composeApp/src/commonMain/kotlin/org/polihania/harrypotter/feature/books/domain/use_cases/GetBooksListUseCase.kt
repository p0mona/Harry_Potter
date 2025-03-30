package org.polihania.harrypotter.feature.books.domain.use_cases

import org.polihania.harrypotter.feature.books.domain.repository.BooksRepository

class GetBooksListUseCase(
    private val repository: BooksRepository
) {
    operator fun invoke() = repository.getBooksList()
}