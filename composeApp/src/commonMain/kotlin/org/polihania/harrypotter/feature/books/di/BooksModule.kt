package org.polihania.harrypotter.feature.books.di

import org.polihania.harrypotter.feature.books.data.api.BooksApi
import org.polihania.harrypotter.feature.books.data.repository.BooksRepositoryImpl
import org.polihania.harrypotter.feature.books.domain.repository.BooksRepository
import org.polihania.harrypotter.feature.books.domain.use_cases.GetBookByIdUseCase
import org.polihania.harrypotter.feature.books.domain.use_cases.GetBooksListUseCase
import org.polihania.harrypotter.feature.books.presentation.books_details.BooksDetailsViewModel
import org.polihania.harrypotter.feature.books.presentation.books_list.BooksListViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val booksModule = module {

    singleOf(::BooksApi)
    factoryOf(::BooksRepositoryImpl).bind<BooksRepository>()
    factoryOf(::GetBooksListUseCase)
    factoryOf(::GetBookByIdUseCase)

    viewModelOf(::BooksListViewModel)
    viewModel { (bookId: Int) ->
        BooksDetailsViewModel(
            getBookByIdUseCase = get(),
            bookId = bookId
        )
    }
}