package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.NavDestination
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val commonRepository: CommonRepository,
    private val mainConverter: MainConverter,
    private val screenRouter: ScreenRouter,
    getAlwaysShowLabelUseCase: GetAlwaysShowLabelUseCase,
    getColorUseCase: GetColorUseCase,
    getThemeUseCase: GetThemeUseCase,
    getTransparentUseCase: GetTransparentUseCase,
) : BaseViewModel<MainScreenState, MainUiState, MainAction>(
    initState = MainScreenState(
        color = getColorUseCase.execute(),
        theme = getThemeUseCase.execute(),
        transparent = getTransparentUseCase.execute(),
        alwaysShowLabel = getAlwaysShowLabelUseCase.execute(),
    ),
    converter = mainConverter::convert
) {

    val navigationCommands = screenRouter.navigationCommands

    init {
        subscribeToSettingsChanges()
    }

    override fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked -> onBottomNavigationClicked(action.navDestination)
    }

    private fun onBottomNavigationClicked(navDestination: NavDestination) {
        screenRouter.navigateTo(navDestination)
    }

    private fun subscribeToSettingsChanges() {
        subscribeToColor()
        subscribeToTheme()
        subscribeToTransparent()
        subscribeToAlwaysShowLabel()
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
}
