package dev.s44khin.simpleweather.main

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo

@Immutable
internal data class MainUiState(
    val color: PrimaryColorVo,
    val theme: ThemeVo,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
)
