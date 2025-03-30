package org.polihania.harrypotter.feature.houses.data.api

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.data.HttpClientProvider
import org.polihania.harrypotter.core.data.fetchDataWithQuery
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.houses.data.dto.HouseDto

class HousesApi(
    clientProvider: HttpClientProvider
) {
    private val client = clientProvider.getClient()

    fun getHouses(
        index: Int? = null,
        max: Int? = null,
        page: Int? = null,
        search: String? = null
    ): Flow<Data<List<HouseDto>>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "houses",
            index = index,
            max = max,
            page = page,
            search = search
        )
    }
}