package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo

sealed class SettingsListAction {

    data class OnUnitsClicked(val tempUnits: TempUnitsVo) : SettingsListAction()
    data class OnColorClicked(val color: PrimaryColorVo) : SettingsListAction()
}
