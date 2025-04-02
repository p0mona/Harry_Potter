package org.polihania.harrypotter.feature.characters.presentation.characters_list

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.navigation.Navigation
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.feature.characters.domain.use_cases.GetCharactersListUseCase

class CharactersListViewModel(
    private val navigation: Navigation,
    private val getCharactersListUseCase: GetCharactersListUseCase,
) : BaseViewModel<CharactersListState, ListScreenIntent>(CharactersListState()) {

    init {
        getCharactersList()
    }

    override fun handleIntent(intent: ListScreenIntent) {
        when (intent) {
            is ListScreenIntent.OnItemClicked -> navigateToCharacterDetails(intent.itemId)
            is ListScreenIntent.UpdateList -> getCharactersList()
        }
    }

    private fun getCharactersList() {
        viewModelScope.launch {
            getCharactersListUseCase().collectLatest { characters ->
                updateState {
                    copy(characters = characters)
                }
            }
        }
    }

    private fun navigateToCharacterDetails(bookId: Int) {
        navigation.navigateToCharacterDetails(bookId)
    }
}