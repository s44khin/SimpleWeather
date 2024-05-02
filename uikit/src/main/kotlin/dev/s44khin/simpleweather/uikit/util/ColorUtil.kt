package dev.s44khin.simpleweather.uikit.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

fun Color.isDark() = luminance() in (0f..<0.5f)

fun Color.isLight() = luminance() in (0.5f..1f)