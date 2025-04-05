package org.polihania.harrypotter.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.polihania.harrypotter.core.utils.Data

fun <T> fetchData(request: suspend () -> T): Flow<Data<T>> = flow {
    emit(Data.Loading)

    try {
        val response = request()
        emit(Data.Success(response))
    } catch (e: Exception) {
        emit(Data.Error(e.message ?: "Unknown error"))
    }
}
