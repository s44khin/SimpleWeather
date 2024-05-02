package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo

@Immutable
data class SettingsListUiState(
    val tempUnits: TempUnitsVo = TempUnitsVo.Kelvin,
    val primaryColor: PrimaryColorVo = PrimaryColorVo.CedarChest,
)
