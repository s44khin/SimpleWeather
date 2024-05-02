package dev.s44khin.simpleweather.common.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.ui.graphics.vector.ImageVector

enum class ThemeVo {
    System, Dark, Light;

    val imageVector: ImageVector
        get() = when (this) {
            System -> Icons.Rounded.AutoAwesome
            Dark -> Icons.Rounded.DarkMode
            Light -> Icons.Rounded.LightMode
        }
}