package org.polihania.harrypotter.feature.characters.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.map
import org.polihania.harrypotter.feature.characters.data.api.CharactersApi
import org.polihania.harrypotter.feature.characters.data.dto.toModel
import org.polihania.harrypotter.feature.characters.data.dto.toModelList
import org.polihania.harrypotter.feature.characters.domain.model.CharacterModel
import org.polihania.harrypotter.feature.characters.domain.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val api: CharactersApi
) : CharactersRepository {
    override fun getCharactersList(): Flow<Data<List<CharacterModel>>> {
        return api.getCharacters().map {
            it.map { data ->
                data.toModelList()
            }
        }
    }


    override fun getCharacterById(id: Int): Flow<Data<CharacterModel>> {
        return api.getCharacterById(index = id).map {
            it.map { data ->
                data.toModel()
            }
        }
    }
}