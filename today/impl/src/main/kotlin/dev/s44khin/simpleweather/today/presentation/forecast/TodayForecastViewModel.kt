package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.today.api.navigation.TodayNavigation
import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase
import dev.s44khin.simpleweather.utils.launchUiCoroutine

internal class TodayForecastViewModel(
    private val getTodayWeatherUseCase: GetTodayWeatherUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<TodayForecastScreenState, TodayForecastUiState, TodayForecastAction>(
    initState = TodayForecastScreenState(),
    converter = TodayForecastConverter::convert
) {

    init {
        getWether()
    }

    override fun onAction(action: TodayForecastAction) = when (action) {
        is TodayForecastAction.OnSearchClicked -> onSearchClicked()
    }

    private fun onSearchClicked() {
        screenRouter.navigateTo(
            navDestination = TodayNavigation.SearchDialog
        )
    }

    private fun getWether() {
        viewModelScope.launchUiCoroutine(
            onError = { throwable ->

            }
        ) {
            val result = getTodayWeatherUseCase.execute()

            screenState = screenState.copy(
                locationName = result.name,
            )
        }
    }
}
