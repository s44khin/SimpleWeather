package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.useCases.GetForecastUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.today.api.navigation.TodayNavigation
import dev.s44khin.simpleweather.utils.launchUiCoroutine

internal class TodayForecastViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<TodayForecastScreenState, TodayForecastUiState, TodayForecastAction>(
    initState = TodayForecastScreenState(),
    converter = TodayForecastConverter::convert
) {

    init {
        getWether()
    }

    override fun onAction(action: TodayForecastAction) = when (action) {
        is TodayForecastAction.OnPullToRefresh -> onPullToRefresh()
        is TodayForecastAction.OnSearchClicked -> onSearchClicked()
    }

    private fun onSearchClicked() {
        screenRouter.navigateTo(
            navDestination = TodayNavigation.SearchDialog
        )
    }

    private fun getWether(onSuccess: (Forecast) -> Unit = {}) {
        viewModelScope.launchUiCoroutine(
            onError = { throwable ->
                screenState = screenState.copy(
                    isRefreshing = false
                )
            }
        ) {
            val result = getForecastUseCase.execute()

            screenState = screenState.copy(
                locationName = result.timezone,
                isRefreshing = false,
                current = result.current,
            )

            onSuccess(result)
        }
    }

    private fun onPullToRefresh() {
        screenState = screenState.copy(
            isRefreshing = true
        )

        getWether()
    }
}
