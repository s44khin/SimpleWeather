package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
    private val getColorUseCase: GetColorUseCase,
    private val getThemeUseCase: GetThemeUseCase,
    private val mainConverter: MainConverter,
    private val commonRepository: CommonRepository,
) : BaseViewModel<MainScreenState, MainUiState, MainAction>(
    initState = MainScreenState(
        color = getColorUseCase.execute(),
        theme = getThemeUseCase.execute(),
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
    }

    override fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked -> onBottomNavigationClicked(action.navDestination)
    }

    private fun onBottomNavigationClicked(navDestination: NavDestination) {
        screenRouter.navigateTo(navDestination)
    }
}
