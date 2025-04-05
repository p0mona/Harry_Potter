package org.polihania.harrypotter.feature.characters.domain.repository

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.characters.domain.model.CharacterModel

interface CharactersRepository {

    fun getCharactersList(): Flow<Data<List<CharacterModel>>>

    fun getCharacterById(id: Int): Flow<Data<CharacterModel>>
}