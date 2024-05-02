package dev.s44khin.simpleweather.core.main

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo

@Immutable
data class MainUiState(
    val color: PrimaryColorVo,
    val theme: ThemeVo,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
)
