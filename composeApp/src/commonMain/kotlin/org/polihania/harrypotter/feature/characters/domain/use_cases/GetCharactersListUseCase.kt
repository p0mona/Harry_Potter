package org.polihania.harrypotter.feature.characters.domain.use_cases

import org.polihania.harrypotter.feature.characters.domain.repository.CharactersRepository

class GetCharactersListUseCase(
    private val repository: CharactersRepository
) {
    operator fun invoke() = repository.getCharactersList()
}