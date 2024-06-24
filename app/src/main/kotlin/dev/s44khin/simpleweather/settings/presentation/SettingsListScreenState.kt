package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme

data class SettingsListScreenState(
    val tempUnits: TempUnits = TempUnits.Kelvin,
    val color: PrimaryColor = PrimaryColor.CedarChest,
    val theme: Theme,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
    val isResetAvailable: Boolean,
)
