package org.polihania.harrypotter.feature.houses.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.map
import org.polihania.harrypotter.feature.houses.data.api.HousesApi
import org.polihania.harrypotter.feature.houses.data.dto.toModelList
import org.polihania.harrypotter.feature.houses.domain.model.HouseModel
import org.polihania.harrypotter.feature.houses.domain.repository.HouseRepository

class HouseRepositoryImpl(
    private val api: HousesApi
) : HouseRepository {
    override fun getHousesList(): Flow<Data<List<HouseModel>>> {
        return api.getHouses().map {
            it.map { data ->
                data.toModelList()
            }
        }
    }
}