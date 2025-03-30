package org.polihania.harrypotter.feature.houses.di

import org.polihania.harrypotter.feature.houses.data.api.HousesApi
import org.polihania.harrypotter.feature.houses.data.repository.HouseRepositoryImpl
import org.polihania.harrypotter.feature.houses.domain.repository.HouseRepository
import org.polihania.harrypotter.feature.houses.domain.use_cases.GetHousesListUseCase
import org.polihania.harrypotter.feature.houses.presentation.HousesViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val housesModule = module {
    singleOf(::HousesApi)
    factoryOf(::HouseRepositoryImpl).bind<HouseRepository>()
    factoryOf(::GetHousesListUseCase)
    viewModelOf(::HousesViewModel)
}