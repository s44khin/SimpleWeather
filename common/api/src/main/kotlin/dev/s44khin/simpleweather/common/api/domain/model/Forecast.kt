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
    val humidity: String,
    val pressure: ForecastCurrentPressure,
    val uvi: ForecastCurrentUvi,
    val iconId: String,
    val weather: ForecastCurrentWeather,
    val wind: ForecustCurrentWind,
)

data class ForecastCurrentWeather(
    val main: String,
    val description: String,
)

data class ForecastCurrentPressure(
    val value: Int,
    val isLow: Boolean,
)

data class ForecastCurrentUvi(
    val value: Float,
    val type: ForecastCurrentUviType,
)

enum class ForecastCurrentUviType {
    Low, Moderate, High, VeryHigh, Extreme;
}

data class ForecustCurrentWind(
    val speed: Int,
    val degree: Float,
    val gust: Int,
)
