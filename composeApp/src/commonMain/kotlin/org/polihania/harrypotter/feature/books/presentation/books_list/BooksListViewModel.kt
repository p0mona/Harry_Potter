package org.polihania.harrypotter.feature.books.presentation.books_list

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.navigation.Navigation
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.feature.books.domain.use_cases.GetBooksListUseCase

class BooksListViewModel(
    private val navigation: Navigation,
    private val getBooksListUseCase: GetBooksListUseCase,
) : BaseViewModel<BooksListState, ListScreenIntent>(BooksListState()) {

    init {
        getBooksList()
    }

    override fun handleIntent(intent: ListScreenIntent) {
        when (intent) {
            is ListScreenIntent.OnItemClicked -> navigateToBookDetails(intent.itemId)
            is ListScreenIntent.Search -> searchBook(intent.query)
            is ListScreenIntent.UpdateList -> getBooksList()
        }
    }

    private fun getBooksList() {
        viewModelScope.launch {
            getBooksListUseCase().collectLatest { books ->
                updateState {
                    copy(books = books)
                }
            }
        }
    }

    private fun searchBook(query: String) {
        viewModelScope.launch {
            searchBookUseCase(query).collectLatest { books ->
                updateState {
                    copy(books = books)
                }
            }
        }
    }

    private fun navigateToBookDetails(bookId: Int) {
        navigation.navigateToBookDetails(bookId)
    }
}
