package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo

sealed class SettingsListAction {

    data class OnUnitsClicked(val tempUnits: TempUnitsVo) : SettingsListAction()
}
