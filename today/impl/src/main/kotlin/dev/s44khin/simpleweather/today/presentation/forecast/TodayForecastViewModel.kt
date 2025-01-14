package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.model.ScreenMode
import dev.s44khin.simpleweather.common.api.domain.useCases.GetBarometerUnitsUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetForecastUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.utils.launchUiCoroutine

internal class TodayForecastViewModel(
    private val getBarometerUnitsUseCase: GetBarometerUnitsUseCase,
    private val getForecastUseCase: GetForecastUseCase,
    private val getUnitsUseCase: GetUnitsUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<TodayForecastScreenState, TodayForecastUiState, TodayForecastAction>(
    initState = TodayForecastScreenState(
        units = getUnitsUseCase.execute(),
        barometerUnits = getBarometerUnitsUseCase.execute(),
    ),
    converter = TodayForecastConverter::convert
) {

    init {
        getWeatherFullscreen()
    }

    override fun onAction(action: TodayForecastAction) = when (action) {
        is TodayForecastAction.OnPullToRefresh -> onPullToRefresh()
        is TodayForecastAction.OnEditClicked -> onEditClicked()
    }

    private fun onEditClicked() {

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
                isRefreshing = false,
                current = result.current,
                mode = ScreenMode.Content,
                units = getUnitsUseCase.execute(),
                barometerUnits = getBarometerUnitsUseCase.execute()
            )

            onSuccess(result)
        }
    }

    private fun getWeatherFullscreen() {
        screenState = screenState.toLoading()
        getWether()
    }


    private fun onPullToRefresh() {
        screenState = screenState.toP2R()
        getWether()
    }
}
