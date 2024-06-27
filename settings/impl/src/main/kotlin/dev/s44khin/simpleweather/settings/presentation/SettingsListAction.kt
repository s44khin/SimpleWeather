package dev.s44khin.simpleweather.settings.presentation

import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo
import dev.s44khin.simpleweather.common.api.presentation.model.UnitsVo

internal sealed class SettingsListAction {

    data class OnColorClicked(val color: PrimaryColorVo) : SettingsListAction()
    data class OnThemeClicked(val theme: ThemeVo) : SettingsListAction()
    data class OnUnitsClicked(val units: UnitsVo) : SettingsListAction()
    data object OnAlwaysShowLabelClicked : SettingsListAction()
    data object OnResetAllSettingsClicked : SettingsListAction()
    data object OnTransparentChanged : SettingsListAction()
}
