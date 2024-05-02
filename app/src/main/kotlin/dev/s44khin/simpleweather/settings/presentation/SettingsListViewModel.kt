package dev.s44khin.simpleweather.settings.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import javax.inject.Inject

@HiltViewModel
class SettingsListViewModel @Inject constructor(
    private val settingsListConverter: SettingsListConverter,
    private val getUnitsUseCase: GetUnitsUseCase,
    private val setUnitsUseCase: SetUnitsUseCase,
) : BaseViewModel<SettingsListScreenState, SettingsListUiState, SettingsListAction>(
    initState = SettingsListScreenState(
        tempUnits = getUnitsUseCase.execute(),
    ),
    converter = settingsListConverter::convert,
) {

    override fun onAction(action: SettingsListAction) = when (action) {
        is SettingsListAction.OnUnitsClicked -> onUnitsClicked(action.tempUnits)
        is SettingsListAction.OnColorClicked -> onColorClicked(action.color)
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
        screenState = screenState.copy(
            color = enumValueOrDefault(
                string = color.name,
                default = PrimaryColorVo.Blue,
            )
        )
    }
}