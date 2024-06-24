package dev.s44khin.simpleweather.main

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.ThemeVo

@Immutable
data class MainUiState(
    val color: PrimaryColorVo,
    val theme: ThemeVo,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
)
