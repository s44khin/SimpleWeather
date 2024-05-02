package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import javax.inject.Inject

class SettingsListConverter @Inject constructor() {

    fun convert(screenState: SettingsListScreenState) = SettingsListUiState(
        tempUnits = enumValueOrDefault(
            string = screenState.tempUnits.name,
            default = TempUnitsVo.Kelvin,
        ),
        primaryColor = enumValueOrDefault(
            string = screenState.color.name,
            default = PrimaryColorVo.CedarChest,
        )
    )
}