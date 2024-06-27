package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units

internal data class SettingsListScreenState(
    val units: Units = Units.Default,
    val color: PrimaryColor = PrimaryColor.CedarChest,
    val theme: Theme,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
    val isResetAvailable: Boolean,
)
