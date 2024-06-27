package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.common.api.presentation.model.toScreenModeVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentPressureVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentWeatherVo

internal object TodayForecastConverter {

    fun convert(screenState: TodayForecastScreenState) = TodayForecastUiState(
        screenMode = screenState.mode.toScreenModeVo(),
        locationName = screenState.locationName,
        isRefreshing = screenState.isRefreshing,
        current = screenState.current?.let {
            ForecastCurrentVo(
                temp = it.temp,
                feelsLike = it.feelsLike,
                min = it.min,
                max = it.max,
                iconId = it.iconId,
                humidity = it.humidity,
                pressure = ForecastCurrentPressureVo(
                    value = it.pressure.value,
                    isLow = it.pressure.isLow,
                ),
                weather = ForecastCurrentWeatherVo(
                    main = it.weather.main,
                    description = it.weather.description,
                )
            )
        }
    )
}