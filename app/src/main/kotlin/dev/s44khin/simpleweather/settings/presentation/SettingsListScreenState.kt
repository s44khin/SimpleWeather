package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo

data class SettingsListScreenState(
    val tempUnits: TempUnits = TempUnits.Kelvin,
    val color: PrimaryColor = PrimaryColor(
        name = PrimaryColorVo.CedarChest.name,
    ),
    val theme: Theme,
    val transparent: Boolean,
)
