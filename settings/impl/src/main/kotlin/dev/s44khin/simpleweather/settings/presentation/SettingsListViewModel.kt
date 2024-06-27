package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.ConfirmationDialogButtonData
import dev.s44khin.simpleweather.common.api.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.common.api.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.IsResetSettingsAvailableUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.ResetSettingsUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetThemeUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetTransparentUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.api.navigation.CommonNavigation
import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo
import dev.s44khin.simpleweather.common.api.presentation.model.UnitsVo
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.settings.api.navigation.SettingsNavigation.List.RESET_CONFIRM_BUTTON_KEY
import dev.s44khin.simpleweather.utils.AutoClearable
import dev.s44khin.simpleweather.utils.NativeText
import dev.s44khin.simpleweather.utils.enumValueOrDefault
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class SettingsListViewModel(
    private val isResetSettingsAvailableUseCase: IsResetSettingsAvailableUseCase,
    private val commonRepository: CommonRepository,
    private val confirmationDialogDataInMemory: AutoClearable<ConfirmationDialogData>,
    private val resetAllSettingsUseCase: ResetSettingsUseCase,
    private val screenRouter: ScreenRouter,
    private val setAlwaysShowLabelUseCase: SetAlwaysShowLabelUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    private val setTransparentUseCase: SetTransparentUseCase,
    private val setUnitsUseCase: SetUnitsUseCase,
    getColorUseCase: GetColorUseCase,
    getThemeUseCase: GetThemeUseCase,
    getTransparentUseCase: GetTransparentUseCase,
    getUnitsUseCase: GetUnitsUseCase,
    getAlwaysShowLabelUseCase: GetAlwaysShowLabelUseCase,
) : BaseViewModel<SettingsListScreenState, SettingsListUiState, SettingsListAction>(
    initState = SettingsListScreenState(
        units = getUnitsUseCase.execute(),
        color = getColorUseCase.execute(),
        theme = getThemeUseCase.execute(),
        transparent = getTransparentUseCase.execute(),
        alwaysShowLabel = getAlwaysShowLabelUseCase.execute(),
        isResetAvailable = isResetSettingsAvailableUseCase.execute(),
    ),
    converter = SettingsListConverter::convert,
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
        is SettingsListAction.OnUnitsClicked -> onUnitsClicked(action.units)
    }

    private fun onUnitsClicked(units: UnitsVo) {
        val tempUnitsDomain = enumValueOrDefault(
            string = units.name,
            default = Units.Default,
        )

        viewModelScope.launch {
            setUnitsUseCase.execute(
                units = tempUnitsDomain,
            )
        }
    }

    private fun onColorClicked(color: PrimaryColorVo) {
        val colorDomain = enumValueOrDefault(
            string = color.name,
            default = PrimaryColor.CedarChest
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
            title = NativeText.Resource(CoreStrings.settings_restore),
            confirmButtonData = ConfirmationDialogButtonData(
                label = NativeText.Resource(CoreStrings.dialog_confirm),
                onClickSignal = RESET_CONFIRM_BUTTON_KEY
            ),
            icon = Icons.Rounded.Autorenew,
            cancelButtonLabel = NativeText.Resource(CoreStrings.dialog_cancel)
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
                    isResetAvailable = isResetSettingsAvailableUseCase.execute(),
                )
            }
        }
    }

    private fun subscribeToTheme() {
        viewModelScope.launch {
            commonRepository.themeFlow.collectLatest {
                screenState = screenState.copy(
                    theme = it,
                    isResetAvailable = isResetSettingsAvailableUseCase.execute(),
                )
            }
        }
    }

    private fun subscribeToTransparent() {
        viewModelScope.launch {
            commonRepository.transparentFlow.collectLatest {
                screenState = screenState.copy(
                    transparent = it,
                    isResetAvailable = isResetSettingsAvailableUseCase.execute(),
                )
            }
        }
    }

    private fun subscribeToAlwaysShowLabel() {
        viewModelScope.launch {
            commonRepository.alwaysShowLabelFlow.collectLatest {
                screenState = screenState.copy(
                    alwaysShowLabel = it,
                    isResetAvailable = isResetSettingsAvailableUseCase.execute(),
                )
            }
        }
    }

    private fun subscribeToUnits() {
        viewModelScope.launch {
            commonRepository.unitsFlow.collectLatest {
                screenState = screenState.copy(
                    units = it,
                    isResetAvailable = isResetSettingsAvailableUseCase.execute(),
                )
            }
        }
    }

    private fun subscribeToSignals() {
        viewModelScope.launch(Dispatchers.IO) {
            screenRouter.signalsFlow.collect { signal ->
                if (signal == RESET_CONFIRM_BUTTON_KEY) {
                    onResetAllSettingsConfirmed()
                }
            }
        }
    }
}