package dev.s44khin.simpleweather.uikit.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import dev.s44khin.simpleweather.uikit.util.isDark

@Composable
fun SimpleTheme(
    primaryLightColor: Color,
    primaryDarkColor: Color,
    transparent: Boolean,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val animatedPrimaryColor by animateColorAsState(
        targetValue = if (isDarkTheme) primaryDarkColor else primaryLightColor,
        label = "animatedPrimaryColor"
    )

    val animatedOnPrimaryColor by animateColorAsState(
        targetValue = if (animatedPrimaryColor.isDark()) Color.White else Color.Black,
        label = "animatedOnPrimaryColor"
    )

    val colors = when {
        isDarkTheme -> getDarkColors(
            primary = animatedPrimaryColor,
            onPrimary = animatedOnPrimaryColor,
            transparent = transparent,
        )

        else -> getLightColors(
            primary = animatedPrimaryColor,
            onPrimary = animatedOnPrimaryColor,
            transparent = transparent,
        )
    }

    MaterialTheme {
        CompositionLocalProvider(
            LocalSimpleColors provides colors,
            content = content,
        )
    }
}

object SimpleTheme {

    val colors: SimpleColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSimpleColors.current
}
