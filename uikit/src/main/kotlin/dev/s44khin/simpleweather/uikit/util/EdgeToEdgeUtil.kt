package dev.s44khin.simpleweather.uikit.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

val StatusBarHeight: Dp
    @Composable
    get() = with(LocalDensity.current) {
        WindowInsets.statusBars.getTop(LocalDensity.current).toDp()
    }
