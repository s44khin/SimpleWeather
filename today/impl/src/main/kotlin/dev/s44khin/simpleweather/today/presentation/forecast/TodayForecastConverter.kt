package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.common.api.presentation.model.toScreenModeVo
import dev.s44khin.simpleweather.common.api.presentation.model.toUnitsVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentPressureVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentUviTypeVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentUviVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentWeatherVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastPrecipitationVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecustCurrentWindVo
import dev.s44khin.simpleweather.utils.enumValueOrDefault

internal object TodayForecastConverter {

    fun convert(screenState: TodayForecastScreenState) = TodayForecastUiState(
        screenMode = screenState.mode.toScreenModeVo(),
        isRefreshing = screenState.isRefreshing,
        units = screenState.units.toUnitsVo(),
        current = screenState.current?.let {
            ForecastCurrentVo(
                locationName = it.locationName,
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
                uvi = ForecastCurrentUviVo(
                    value = screenState.current.uvi.value,
                    type = enumValueOrDefault(
                        string = screenState.current.uvi.type.name,
                        default = ForecastCurrentUviTypeVo.Low,
                    )
                ),
                weather = ForecastCurrentWeatherVo(
                    main = it.weather.main,
                    description = it.weather.description,
                ),
                wind = ForecustCurrentWindVo(
                    speed = it.wind.speed,
                    gust = it.wind.gust,
                    degree = it.wind.degree,
                ),
                precipitation = ForecastPrecipitationVo(
                    pop = screenState.current.precipitation.pop,
                    rain = screenState.current.precipitation.rain,
                    snow = screenState.current.precipitation.snow,
                ),
                time = screenState.current.time,
            )
        }
    )
}