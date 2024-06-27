package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import dev.s44khin.simpleweather.utils.enumValueOrDefault

internal object SettingsListConverter {

    fun convert(screenState: SettingsListScreenState) =
        SettingsListUiState(
            tempUnits = enumValueOrDefault(
                string = screenState.tempUnits.name,
                default = TempUnitsVo.Kelvin,
            ),
            primaryColor = enumValueOrDefault(
                string = screenState.color.name,
                default = PrimaryColorVo.CedarChest,
            ),
            theme = enumValueOrDefault(
                string = screenState.theme.name,
                default = ThemeVo.System,
            ),
            transparent = screenState.transparent,
            alwaysShowLabel = screenState.alwaysShowLabel,
            isResetAvailable = screenState.isResetAvailable,
        )
}