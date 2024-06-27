package dev.s44khin.simpleweather.today.presentation.forecast.model

import androidx.compose.runtime.Immutable

@Immutable
internal data class ForecastCurrentVo(
    val temp: String,
    val feelsLike: String,
    val min: String?,
    val max: String?,
    val iconId: String,
    val weather: ForecastCurrentWeatherVo,
)

@Immutable
internal data class ForecastCurrentWeatherVo(
    val main: String,
    val description: String,
)
