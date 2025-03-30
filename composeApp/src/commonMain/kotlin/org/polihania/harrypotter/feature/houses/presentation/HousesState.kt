package org.polihania.harrypotter.feature.houses.presentation

import androidx.compose.runtime.Stable
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.houses.domain.model.HouseModel

@Stable
data class HousesState(
    val houses: Data<List<HouseModel>> = Data.Empty,
)