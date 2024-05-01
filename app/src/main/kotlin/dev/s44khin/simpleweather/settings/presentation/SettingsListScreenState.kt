package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.domain.model.TempUnits

data class SettingsListScreenState(
    val tempUnits: TempUnits = TempUnits.Kelvin,
)
