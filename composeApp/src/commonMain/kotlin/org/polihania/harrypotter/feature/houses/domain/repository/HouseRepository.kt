package org.polihania.harrypotter.feature.houses.domain.repository

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.houses.domain.model.HouseModel

interface HouseRepository {

    fun getHousesList(): Flow<Data<List<HouseModel>>>
}