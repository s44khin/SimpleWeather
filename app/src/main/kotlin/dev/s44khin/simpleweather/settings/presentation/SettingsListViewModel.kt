package dev.s44khin.simpleweather.settings.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import javax.inject.Inject

@HiltViewModel
class SettingsListViewModel @Inject constructor(
    private val settingsListConverter: SettingsListConverter,
) : BaseViewModel<SettingsListScreenState, SettingsListUiState, SettingsListAction>(
    initState = SettingsListScreenState(),
    converter = settingsListConverter::convert,
) {

    override fun onAction(action: SettingsListAction) = when (action) {
        is SettingsListAction.OnUnitsClicked -> onUnitsClicked(action.tempUnits)
    }

    private fun onUnitsClicked(tempUnits: TempUnitsVo) {
        screenState = screenState.copy(
            tempUnits = enumValueOrDefault(
                string = tempUnits.name,
                default = TempUnits.Kelvin,
            ),
        )
    }
}