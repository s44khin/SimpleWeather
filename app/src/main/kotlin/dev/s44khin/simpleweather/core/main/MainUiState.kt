package dev.s44khin.simpleweather.core.main

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo

@Immutable
data class MainUiState(
    val color: PrimaryColorVo
)
