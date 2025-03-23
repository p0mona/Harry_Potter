package org.polihania.harrypotter.core.utils

import androidx.compose.runtime.Composable

sealed class Data<out T> {
    data object Empty : Data<Nothing>()
    data object Loading : Data<Nothing>()
    data class Success<T>(val data: T) : Data<T>()
    data class Error(val error: String) : Data<Nothing>()
}

inline fun <T, R> Data<T>.map(transform: (T) -> R): Data<R> {
    return when (this) {
        is Data.Success -> Data.Success(transform(this.data))
        is Data.Error -> this
        is Data.Empty -> Data.Empty
        is Data.Loading -> Data.Loading
    }
}

@Composable
fun <T> Data<T>.handle(
    onEmpty: @Composable () -> Unit = {},
    onLoading: @Composable () -> Unit = {},
    onSuccess: @Composable (T) -> Unit = {},
    onError: @Composable (String) -> Unit = {},
) {
    when (this) {
        is Data.Empty -> onEmpty()
        is Data.Loading -> onLoading()
        is Data.Success -> onSuccess(data)
        is Data.Error -> onError(error)
    }
}
