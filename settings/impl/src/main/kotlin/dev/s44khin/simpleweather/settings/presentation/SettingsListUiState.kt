package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.model.BarometerUnitsVo
import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo
import dev.s44khin.simpleweather.common.api.presentation.model.UnitsVo

@Immutable
internal data class SettingsListUiState(
    val units: UnitsVo = UnitsVo.Default,
    val barometerUnits: BarometerUnitsVo = BarometerUnitsVo.MercuryСolumn,
    val primaryColor: PrimaryColorVo = PrimaryColorVo.CedarChest,
    val theme: ThemeVo = ThemeVo.System,
    val transparent: Boolean = true,
    val alwaysShowLabel: Boolean = true,
    val isResetAvailable: Boolean = false,
)
