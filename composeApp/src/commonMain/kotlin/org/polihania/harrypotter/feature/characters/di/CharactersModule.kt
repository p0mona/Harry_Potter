package org.polihania.harrypotter.feature.characters.di

import org.polihania.harrypotter.feature.characters.data.api.CharactersApi
import org.polihania.harrypotter.feature.characters.data.repository.CharactersRepositoryImpl
import org.polihania.harrypotter.feature.characters.domain.repository.CharactersRepository
import org.polihania.harrypotter.feature.characters.domain.use_cases.GetCharacterByIdUseCase
import org.polihania.harrypotter.feature.characters.domain.use_cases.GetCharactersListUseCase
import org.polihania.harrypotter.feature.characters.presentation.characters_details.CharactersDetailsViewModel
import org.polihania.harrypotter.feature.characters.presentation.characters_list.CharactersListViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val charactersModule = module {

    singleOf(::CharactersApi)
    factoryOf(::CharactersRepositoryImpl).bind<CharactersRepository>()
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetCharactersListUseCase)

    viewModelOf(::CharactersListViewModel)
    viewModel { (characterId: Int) ->
        CharactersDetailsViewModel(
            navigation = get(),
            getCharacterByIdUseCase = get(),
            characterId = characterId
        )
    }
}