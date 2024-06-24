package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.ThemeVo
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo

@Immutable
data class SettingsListUiState(
    val tempUnits: TempUnitsVo = TempUnitsVo.Kelvin,
    val primaryColor: PrimaryColorVo = PrimaryColorVo.CedarChest,
    val theme: ThemeVo = ThemeVo.System,
    val transparent: Boolean = true,
    val alwaysShowLabel: Boolean = true,
    val isResetAvailable: Boolean = false,
)
