package org.polihania.harrypotter.feature.houses.domain.use_cases

import org.polihania.harrypotter.feature.houses.domain.repository.HouseRepository

class GetHousesListUseCase(
    private val repository: HouseRepository
) {
    operator fun invoke() = repository.getHousesList()
}