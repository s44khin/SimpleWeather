package dev.s44khin.simpleweather.common.api.domain.model

data class Forecast(
    val timezone: String,
    val current: ForecastCurrent,
)

data class ForecastCurrent(
    val temp: String,
    val feelsLike: String,
    val min: String?,
    val max: String?,
    val iconId: String,
    val weather: ForecastCurrentWeather,
)

data class ForecastCurrentWeather(
    val main: String,
    val description: String,
)