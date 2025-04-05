package org.polihania.harrypotter.core.ui_kit.foundation

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import harrypotter.composeapp.generated.resources.HARRYP
import harrypotter.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun getPotterFontFamily(): FontFamily {
    return FontFamily(
        Font(Res.font.HARRYP, FontWeight.Normal),
        Font(Res.font.HARRYP, FontWeight.Medium),
        Font(Res.font.HARRYP, FontWeight.Bold)
    )
}

val PotterTypography
    @Composable get() = Typography(
        displayLarge = Typography().displayLarge.copy(fontFamily = getPotterFontFamily()),
        displayMedium = Typography().displayMedium.copy(fontFamily = getPotterFontFamily()),
        displaySmall = Typography().displaySmall.copy(fontFamily = getPotterFontFamily()),
        headlineLarge = Typography().headlineLarge.copy(fontFamily = getPotterFontFamily()),
        headlineMedium = Typography().headlineMedium.copy(fontFamily = getPotterFontFamily()),
        headlineSmall = Typography().headlineSmall.copy(fontFamily = getPotterFontFamily()),
        titleLarge = Typography().titleLarge.copy(fontFamily = getPotterFontFamily()),
        titleMedium = Typography().titleMedium.copy(fontFamily = getPotterFontFamily()),
        titleSmall = Typography().titleSmall.copy(fontFamily = getPotterFontFamily()),
        bodyLarge = Typography().bodyLarge.copy(fontFamily = getPotterFontFamily()),
        bodyMedium = Typography().bodyMedium.copy(fontFamily = getPotterFontFamily()),
        bodySmall = Typography().bodySmall.copy(fontFamily = getPotterFontFamily()),
        labelLarge = Typography().labelLarge.copy(fontFamily = getPotterFontFamily()),
        labelMedium = Typography().labelMedium.copy(fontFamily = getPotterFontFamily()),
        labelSmall = Typography().labelSmall.copy(fontFamily = getPotterFontFamily())
    )