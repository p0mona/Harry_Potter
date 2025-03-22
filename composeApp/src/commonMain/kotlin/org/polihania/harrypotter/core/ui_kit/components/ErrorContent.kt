package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.error_content_button_text
import harrypotter.composeapp.generated.resources.error_content_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorContent(
    title: String = "",
    onUpdateClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title.takeIf { it.isNotEmpty() }
            ?: stringResource(Res.string.error_content_title))
        Button(
            onClick = onUpdateClick
        ) {
            Text(text = stringResource(Res.string.error_content_button_text))
        }
    }
}

