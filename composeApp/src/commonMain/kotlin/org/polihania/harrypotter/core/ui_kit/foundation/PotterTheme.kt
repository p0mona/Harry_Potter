package org.polihania.harrypotter.core.ui_kit.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun PotterTheme(
    house: HogwartsHouse,
    darkTheme: Boolean = rememberIsDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = getHouseColorScheme(house, darkTheme)

    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography,
        content = content
    )
}

enum class HogwartsHouse {
    Gryffindor, Slytherin, Ravenclaw, Hufflepuff
}

@Composable
fun getHouseColorScheme(house: HogwartsHouse, darkTheme: Boolean): ColorScheme {
    return when (house) {
        HogwartsHouse.Gryffindor -> if (darkTheme) GryffindorDarkColors else GryffindorLightColors
        HogwartsHouse.Slytherin -> if (darkTheme) SlytherinDarkColors else SlytherinLightColors
        HogwartsHouse.Ravenclaw -> if (darkTheme) RavenclawDarkColors else RavenclawLightColors
        HogwartsHouse.Hufflepuff -> if (darkTheme) HufflepuffDarkColors else HufflepuffLightColors
    }
}

