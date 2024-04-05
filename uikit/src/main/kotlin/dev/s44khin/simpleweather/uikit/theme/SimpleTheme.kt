package dev.s44khin.simpleweather.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun SimpleTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (isDarkTheme) getDarkColors() else getLightColors()

    CompositionLocalProvider(
        LocalSimpleColors provides colors,
        LocalRippleTheme provides SimpleRippleTheme,
        content = content,
    )
}

object SimpleTheme {

    val colors: SimpleColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSimpleColors.current
}
