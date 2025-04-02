package org.polihania.harrypotter.feature.characters.domain.use_cases

import org.polihania.harrypotter.feature.characters.domain.repository.CharactersRepository

class GetCharacterByIdUseCase(
    private val repository: CharactersRepository
) {
    operator fun invoke(characterId: Int) = repository.getCharacterById(characterId)
}