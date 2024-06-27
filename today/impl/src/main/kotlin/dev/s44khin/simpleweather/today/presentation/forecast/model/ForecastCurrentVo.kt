package dev.s44khin.simpleweather.today.presentation.forecast.model

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.resources.CoreRaw

@Immutable
internal data class ForecastCurrentVo(
    val temp: String,
    val feelsLike: String,
    val min: String?,
    val max: String?,
    val humidity: String,
    val pressure: ForecastCurrentPressureVo,
    val iconId: String,
    val weather: ForecastCurrentWeatherVo,
)

@Immutable
internal data class ForecastCurrentWeatherVo(
    val main: String,
    val description: String,
)

@Immutable
internal data class ForecastCurrentPressureVo(
    val value: Int,
    val isLow: Boolean,
) {

    val raw: Int = if (isLow) CoreRaw.ic_pressure_low else CoreRaw.ic_pressure_high
}
