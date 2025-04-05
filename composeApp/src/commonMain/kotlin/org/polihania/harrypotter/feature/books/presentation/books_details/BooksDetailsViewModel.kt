package org.polihania.harrypotter.feature.books.presentation.books_details


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.DetailsScreenIntent
import org.polihania.harrypotter.feature.books.domain.use_cases.GetBookByIdUseCase

class BooksDetailsViewModel(
    private val getBookByIdUseCase: GetBookByIdUseCase,
    private val bookId: Int
) : BaseViewModel<BooksDetailsState, DetailsScreenIntent>(BooksDetailsState()) {

    init {
        updateDetailsData()
    }

    override fun handleIntent(intent: DetailsScreenIntent) {
        when (intent) {
            is DetailsScreenIntent.UpdateDetailsData -> updateDetailsData()
        }
    }

    private fun updateDetailsData() {
        viewModelScope.launch {
            getBookByIdUseCase(bookId).collectLatest { book ->
                updateState {
                    copy(book = book)
                }
            }
        }
    }
}