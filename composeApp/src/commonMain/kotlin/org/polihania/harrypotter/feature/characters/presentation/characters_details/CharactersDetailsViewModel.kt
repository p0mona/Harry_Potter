package org.polihania.harrypotter.feature.characters.presentation.characters_details

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.navigation.Navigation
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.DetailsScreenIntent
import org.polihania.harrypotter.feature.characters.domain.use_cases.GetCharacterByIdUseCase

class CharactersDetailsViewModel(
    private val navigation: Navigation,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val characterId: Int
) : BaseViewModel<CharactersDetailsState, DetailsScreenIntent>(CharactersDetailsState()) {


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
            getCharacterByIdUseCase(characterId).collectLatest { character ->
                updateState {
                    copy(character = character)
                }
            }
        }
    }
}