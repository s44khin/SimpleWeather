package dev.s44khin.simpleweather.common.data.mappers

import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrent
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentPressure
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentUvi
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentUviType
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentWeather
import dev.s44khin.simpleweather.common.api.domain.model.ForecastPrecipitation
import dev.s44khin.simpleweather.common.api.domain.model.ForecustCurrentWind
import dev.s44khin.simpleweather.common.data.model.ForecastResponse
import kotlin.math.roundToInt

internal class ForecastMapper {

    fun map(response: ForecastResponse) = Forecast(
        timezone = response.timezone,
        current = ForecastCurrent(
            temp = formatTemp(
                value = response.current.temp,
            ),
            feelsLike = formatTemp(
                value = response.current.feelsLike,
            ),
            min = response.daily.getOrNull(0)?.let {
                formatTemp(
                    value = it.temp.min,
                )
            },
            max = response.daily.getOrNull(0)?.let {
                formatTemp(
                    value = it.temp.max,
                )
            },
            pressure = ForecastCurrentPressure(
                value = response.current.pressure,
                isLow = pressureIsLow(response.current.pressure)
            ),
            humidity = response.current.humidity,
            iconId = response.current.weather[0].icon,
            uvi = ForecastCurrentUvi(
                value = response.current.uvi.coerceIn(0f..11f),
                type = getUviType(response.current.uvi.coerceIn(0f..11f))
            ),
            weather = response.current.weather[0].let {
                ForecastCurrentWeather(
                    main = it.main,
                    description = it.description.replaceFirstChar { it.uppercaseChar() },
                )
            },
            wind = ForecustCurrentWind(
                speed = response.current.windSpeed.roundToInt(),
                degree = response.current.windDegree,
                gust = response.current.windGust?.roundToInt() ?: 0,
            ),
            precipitation = ForecastPrecipitation(
                pop = ((response.hourly.getOrNull(0)?.pop ?: 0f) * 100).roundToInt(),
                rain = response.hourly.getOrNull(0)?.rain?.value ?: 0f,
                snow = response.hourly.getOrNull(0)?.snow?.value ?: 0f,
            )
        )
    )

    private fun formatTemp(value: String): String {
        return (value.toDoubleOrNull()?.toInt()?.toString() ?: "NoN")
    }

    private fun pressureIsLow(value: Int) = value < 1013

    private fun getUviType(value: Float) = when (value) {
        in 0f..<3f -> ForecastCurrentUviType.Low
        in 3f..<5f -> ForecastCurrentUviType.Moderate
        in 5f..<7f -> ForecastCurrentUviType.High
        in 7f..10f -> ForecastCurrentUviType.VeryHigh
        else -> ForecastCurrentUviType.Extreme
    }
}
