package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.handle

@Composable
fun <T> ListScreenContent(
    modifier: Modifier = Modifier,
    data: Data<List<T>>,
    onErrorButtonClick: () -> Unit,
    topContent: @Composable (() -> Unit)? = null,
    bottomContent: @Composable (() -> Unit)? = null,
    itemContent: @Composable (T) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        topContent?.invoke()
        data.handle(
            onLoading = { LoadingContent() },
            onSuccess = { data ->
                LazyColumn {
                    items(data) { item ->
                        itemContent(item)
                    }
                }
            },
            onError = { ErrorContent(onUpdateClick = onErrorButtonClick) }
        )
        bottomContent?.invoke()
    }
}