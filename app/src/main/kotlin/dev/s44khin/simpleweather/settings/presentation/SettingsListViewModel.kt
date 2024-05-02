package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.common.clearable.AutoClearable
import dev.s44khin.simpleweather.common.core.navigation.CommonNavigation
import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogButtonData
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import dev.s44khin.simpleweather.common.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.ResetSettingsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetTransparentUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import dev.s44khin.simpleweather.settings.core.navigation.SettingsNavigation.List.RESET_CONFIRM_BUTTON_KEY
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import dev.s44khin.simpleweather.uikit.util.NativeText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsListViewModel @Inject constructor(
    private val commonRepository: CommonRepository,
    private val resetAllSettingsUseCase: ResetSettingsUseCase,
    private val screenRouter: ScreenRouter,
    private val setAlwaysShowLabelUseCase: SetAlwaysShowLabelUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    private val setTransparentUseCase: SetTransparentUseCase,
    private val setUnitsUseCase: SetUnitsUseCase,
    private val settingsListConverter: SettingsListConverter,
    private val confirmationDialogDataInMemory: AutoClearable<ConfirmationDialogData>,
    getColorUseCase: GetColorUseCase,
    getThemeUseCase: GetThemeUseCase,
    getTransparentUseCase: GetTransparentUseCase,
    getUnitsUseCase: GetUnitsUseCase,
    getAlwaysShowLabelUseCase: GetAlwaysShowLabelUseCase,
) : BaseViewModel<SettingsListScreenState, SettingsListUiState, SettingsListAction>(
    initState = SettingsListScreenState(
        tempUnits = getUnitsUseCase.execute(),
        color = getColorUseCase.execute(),
        theme = getThemeUseCase.execute(),
        transparent = getTransparentUseCase.execute(),
        alwaysShowLabel = getAlwaysShowLabelUseCase.execute(),
    ),
    converter = settingsListConverter::convert,
) {

    init {
        subscribeToSettingsChanges()
        subscribeToSignals()
    }

    override fun onAction(action: SettingsListAction) = when (action) {
        is SettingsListAction.OnAlwaysShowLabelClicked -> onAlwaysShowLabelClicked()
        is SettingsListAction.OnColorClicked -> onColorClicked(action.color)
        is SettingsListAction.OnResetAllSettingsClicked -> onResetAllSettingsClicked()
        is SettingsListAction.OnThemeClicked -> onThemeClicked(action.theme)
        is SettingsListAction.OnTransparentChanged -> onTransparentChanged()
        is SettingsListAction.OnUnitsClicked -> onUnitsClicked(action.tempUnits)
    }

    private fun onUnitsClicked(tempUnits: TempUnitsVo) {
        val tempUnitsDomain = enumValueOrDefault(
            string = tempUnits.name,
            default = TempUnits.Kelvin,
        )

        viewModelScope.launch {
            setUnitsUseCase.execute(
                units = tempUnitsDomain,
            )
        }
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
    }

    private fun onThemeClicked(theme: ThemeVo) {
        val themeDomain = enumValueOrDefault(
            string = theme.name,
            default = Theme.System,
        )

        viewModelScope.launch {
            setThemeUseCase.execute(themeDomain)
        }
    }

    private fun onTransparentChanged() {
        viewModelScope.launch {
            setTransparentUseCase.execute(screenState.transparent.not())
        }
    }

    private fun onAlwaysShowLabelClicked() {
        viewModelScope.launch {
            setAlwaysShowLabelUseCase.execute(screenState.alwaysShowLabel.not())
        }
    }

    private fun onResetAllSettingsClicked() {
        confirmationDialogDataInMemory.value = ConfirmationDialogData(
            title = NativeText.Resource(R.string.settings_restore),
            confirmButtonData = ConfirmationDialogButtonData(
                label = NativeText.Resource(R.string.dialog_confirm),
                onClickSignal = RESET_CONFIRM_BUTTON_KEY
            ),
            icon = Icons.Rounded.Autorenew,
            cancelButtonLabel = NativeText.Resource(R.string.dialog_cancel)
        )

        screenRouter.navigateTo(
            navDestination = CommonNavigation.ConfirmationDialog
        )
    }

    private fun onResetAllSettingsConfirmed() {
        viewModelScope.launch {
            resetAllSettingsUseCase.execute()
        }
    }

    private fun subscribeToSettingsChanges() {
        subscribeToColor()
        subscribeToTheme()
        subscribeToTransparent()
        subscribeToAlwaysShowLabel()
        subscribeToUnits()
    }

    private fun subscribeToColor() {
        viewModelScope.launch {
            commonRepository.colorFlow.collect {
                screenState = screenState.copy(
                    color = it,
                )
            }
        }
    }

    private fun subscribeToTheme() {
        viewModelScope.launch {
            commonRepository.themeFlow.collectLatest {
                screenState = screenState.copy(
                    theme = it
                )
            }
        }
    }

    private fun subscribeToTransparent() {
        viewModelScope.launch {
            commonRepository.transparentFlow.collectLatest {
                screenState = screenState.copy(
                    transparent = it
                )
            }
        }
    }

    private fun subscribeToAlwaysShowLabel() {
        viewModelScope.launch {
            commonRepository.alwaysShowLabelFlow.collectLatest {
                screenState = screenState.copy(
                    alwaysShowLabel = it
                )
            }
        }
    }

    private fun subscribeToUnits() {
        viewModelScope.launch {
            commonRepository.unitsFlow.collectLatest {
                screenState = screenState.copy(
                    tempUnits = it
                )
            }
        }
    }

    private fun subscribeToSignals() {
        viewModelScope.launch(Dispatchers.IO) {
            screenRouter.signalFlow.collect { signal ->
                if (signal == RESET_CONFIRM_BUTTON_KEY) {
                    onResetAllSettingsConfirmed()
                }
            }
        }
    }
}