package org.polihania.harrypotter.core.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.utils.Data

inline fun <reified T> fetchDataWithQuery(
    client: HttpClient,
    endpoint: String,
    index: Int? = null,
    max: Int? = null,
    page: Int? = null,
    search: String? = null
): Flow<Data<T>> = fetchData {
    client.get(endpoint) {
        url {
            index?.let { parameters.append("index", it.toString()) }
            max?.let { parameters.append("max", it.toString()) }
            page?.let { parameters.append("page", it.toString()) }
            search?.let { parameters.append("search", it) }
        }
    }.body()
}
