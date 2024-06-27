package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentWeatherVo

internal object TodayForecastConverter {

    fun convert(screenState: TodayForecastScreenState) = TodayForecastUiState(
        locationName = screenState.locationName,
        isRefreshing = screenState.isRefreshing,
        current = screenState.current?.let {
            ForecastCurrentVo(
                temp = it.temp,
                feelsLike = it.feelsLike,
                iconId = it.iconId,
                weather = ForecastCurrentWeatherVo(
                    main = it.weather.main,
                    description = it.weather.description,
                )
            )
        }
    )
}