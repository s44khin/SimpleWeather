package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.today.core.navigation.TodayNavigation
import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase

class TodayForecastViewModel(
    private val converter: TodayForecastConverter,
    private val getTodayWeatherUseCase: GetTodayWeatherUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<TodayForecastScreenState, TodayForecastUiState, TodayForecastAction>(
    initState = TodayForecastScreenState,
    converter = converter::convert
) {

    override fun onAction(action: TodayForecastAction) = when (action) {
        is TodayForecastAction.OnSearchClicked -> onSearchClicked()
    }

    private fun onSearchClicked() {
        screenRouter.navigateTo(
            navDestination = TodayNavigation.SearchDialog
        )
    }
}
