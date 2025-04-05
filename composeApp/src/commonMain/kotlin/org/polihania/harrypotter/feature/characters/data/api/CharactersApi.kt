package org.polihania.harrypotter.feature.characters.data.api

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.data.HttpClientProvider
import org.polihania.harrypotter.core.data.fetchDataWithQuery
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.characters.data.dto.CharacterDto

class CharactersApi(
    clientProvider: HttpClientProvider
) {
    private val client = clientProvider.getClient()

    fun getCharacters(
        max: Int? = null,
        page: Int? = null,
        search: String? = null
    ): Flow<Data<List<CharacterDto>>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "characters",
            index = null,
            max = max,
            page = page,
            search = search
        )
    }

    fun getCharacterById(
        index: Int
    ): Flow<Data<CharacterDto>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "characters",
            index = index,
            max = null,
            page = null,
            search = null
        )
    }
}