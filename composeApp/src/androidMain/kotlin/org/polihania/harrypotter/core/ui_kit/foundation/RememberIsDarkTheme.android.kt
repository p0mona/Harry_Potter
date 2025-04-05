package org.polihania.harrypotter.core.ui_kit.foundation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
actual fun rememberIsDarkTheme(): Boolean {
    return isSystemInDarkTheme()
}
