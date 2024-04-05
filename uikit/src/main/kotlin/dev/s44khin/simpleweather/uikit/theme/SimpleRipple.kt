package dev.s44khin.simpleweather.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal object SimpleRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor(): Color = SimpleTheme.colors.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        contentColor = SimpleTheme.colors.primary,
        lightTheme = isSystemInDarkTheme(),
    )
}