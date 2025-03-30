package org.polihania.harrypotter.feature.spells.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.feature.spells.domain.use_cases.GetSpellsListUseCase

class SpellsViewModel(
    private val getSpellsListUseCase: GetSpellsListUseCase,
) : BaseViewModel<SpellsState, ListScreenIntent>(SpellsState()) {

    init {
        getSpellsList()
    }


    private fun getSpellsList() {
        viewModelScope.launch {
            getSpellsListUseCase().collectLatest { spells ->
                updateState {
                    copy(spells = spells)
                }
            }
        }
    }

    override fun handleIntent(intent: ListScreenIntent) {
        when (intent) {
            is ListScreenIntent.OnItemClicked -> {
                // TODO: Handle item click
            }
            is ListScreenIntent.UpdateList -> getSpellsList()
        }
    }


}