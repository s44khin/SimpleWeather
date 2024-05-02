package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo

sealed class SettingsListAction {

    data class OnColorClicked(val color: PrimaryColorVo) : SettingsListAction()
    data class OnThemeClicked(val theme: ThemeVo) : SettingsListAction()
    data class OnUnitsClicked(val tempUnits: TempUnitsVo) : SettingsListAction()
    data object OnAlwaysShowLabelClicked : SettingsListAction()
    data object OnResetAllSettingsClicked : SettingsListAction()
    data object OnTransparentChanged : SettingsListAction()
}
