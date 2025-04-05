package org.polihania.harrypotter.feature.houses.presentation


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.feature.houses.domain.use_cases.GetHousesListUseCase

class HousesViewModel(
    private val getHousesListUseCase: GetHousesListUseCase,
) : BaseViewModel<HousesState, HousesScreenIntent>(HousesState()) {

    init {
        getHousesList()
    }

    override fun handleIntent(intent: HousesScreenIntent) {
        when (intent) {

            is HousesScreenIntent.UpdateList -> getHousesList()
        }
    }

    private fun getHousesList() {
        viewModelScope.launch {
            getHousesListUseCase().collectLatest { houses ->
                updateState {
                    copy(houses = houses)
                }
            }
        }
    }
}