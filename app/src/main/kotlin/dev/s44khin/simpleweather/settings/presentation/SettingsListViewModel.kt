package dev.s44khin.simpleweather.settings.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsListViewModel @Inject constructor(
    private val getColorUseCase: GetColorUseCase,
    private val getUnitsUseCase: GetUnitsUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setUnitsUseCase: SetUnitsUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    private val getThemeUseCase: GetThemeUseCase,
    private val settingsListConverter: SettingsListConverter,
) : BaseViewModel<SettingsListScreenState, SettingsListUiState, SettingsListAction>(
    initState = SettingsListScreenState(
        tempUnits = getUnitsUseCase.execute(),
        color = getColorUseCase.execute(),
        theme = getThemeUseCase.execute(),
    ),
    converter = settingsListConverter::convert,
) {

    override fun onAction(action: SettingsListAction) = when (action) {
        is SettingsListAction.OnUnitsClicked -> onUnitsClicked(action.tempUnits)
        is SettingsListAction.OnColorClicked -> onColorClicked(action.color)
        is SettingsListAction.OnThemeClicked -> onThemeClicked(action.theme)
    }

    private fun onUnitsClicked(tempUnits: TempUnitsVo) {
        val tempUnitsDomain = enumValueOrDefault(
            string = tempUnits.name,
            default = TempUnits.Kelvin,
        )

        setUnitsUseCase.execute(
            units = tempUnitsDomain,
        )

        screenState = screenState.copy(
            tempUnits = tempUnitsDomain,
        )
    }

    private fun onColorClicked(color: PrimaryColorVo) {
        val colorDomain = PrimaryColor(
            name = color.name,
        )

        viewModelScope.launch {
            setColorUseCase.execute(
                color = colorDomain,
            )
        }

        screenState = screenState.copy(
            color = colorDomain
        )
    }

    private fun onThemeClicked(theme: ThemeVo) {
        val themeDomain = enumValueOrDefault(
            string = theme.name,
            default = Theme.System,
        )

        viewModelScope.launch {
            setThemeUseCase.execute(themeDomain)
        }

        screenState = screenState.copy(
            theme = themeDomain
        )
    }
}