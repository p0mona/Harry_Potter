package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.handle

@Composable
fun <T> DetailsScreenContent(
    data: Data<T>,
    onErrorButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(8.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        data.handle(
            onLoading = { CircularProgressIndicator() },
            onSuccess = { data ->
                content(data)
            },
            onError = { ErrorContent(onUpdateClick = onErrorButtonClick) }
        )
    }
}
