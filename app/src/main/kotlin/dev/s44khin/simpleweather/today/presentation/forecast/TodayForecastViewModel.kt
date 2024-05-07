package dev.s44khin.simpleweather.today.presentation.forecast

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.core.navigation.CommonNavigation
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase
import javax.inject.Inject

@HiltViewModel
class TodayForecastViewModel @Inject constructor(
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
            navDestination = CommonNavigation.SearchDialog
        )
    }
}
