package dev.s44khin.simpleweather.today.presentation.forecast.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal enum class DangerLevel {
    Red, Yellow;
}

internal val DangerLevel?.color
    @Composable
    get() = if (this == DangerLevel.Red) {
        Color.Red
    } else {
        Color.Yellow
    }
