package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
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

    val navigationCommand = screenRouter.navigationCommand

    init {
        viewModelScope.launch {
            commonRepository.colorFlow.collectLatest {
                screenState = screenState.copy(
                    color = it,
                )
            }
        }

        viewModelScope.launch {
            commonRepository.themeFlow.collectLatest {
                screenState = screenState.copy(
                    theme = it
                )
            }
        }

        viewModelScope.launch {
            commonRepository.transparentFlow.collectLatest {
                screenState = screenState.copy(
                    transparent = it
                )
            }
        }

        viewModelScope.launch {
            commonRepository.alwaysShowLabelFlow.collectLatest {
                screenState = screenState.copy(
                    alwaysShowLabel = it
                )
            }
        }
    }

    override fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked -> onBottomNavigationClicked(action.navDestination)
    }

    private fun onBottomNavigationClicked(navDestination: NavDestination) {
        screenRouter.navigateTo(navDestination)
    }
}
