package dev.s44khin.simpleweather.common.data.mappers

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrent
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentPressure
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentUvi
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentUviType
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentWeather
import dev.s44khin.simpleweather.common.api.domain.model.ForecastPrecipitation
import dev.s44khin.simpleweather.common.api.domain.model.ForecastSuntime
import dev.s44khin.simpleweather.common.api.domain.model.ForecustCurrentWind
import dev.s44khin.simpleweather.common.data.model.ForecastResponse
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

internal class ForecastMapper {

    fun map(response: ForecastResponse, barometerUnits: BarometerUnits) = Forecast(
        current = ForecastCurrent(
            locationName = response.timezone,
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
                value = mapPressure(
                    value = response.current.pressure,
                    units = barometerUnits
                ),
                isLow = pressureIsLow(
                    value = response.current.pressure,
                    barometerUnits = barometerUnits
                )
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
            ),
            time = timeMapper(response.current.dt),
            suntime = ForecastSuntime(
                sunset = timeMapper(
                    unix = response.current.sunset,
                ),
                sunrise = timeMapper(
                    unix = response.current.sunrise
                ),
                isNight = response.current.sunrise < response.current.sunset
            )
        )
    )

    private fun formatTemp(value: String): String {
        return (value.toDoubleOrNull()?.toInt()?.toString() ?: "NoN")
    }

    private fun pressureIsLow(value: Int, barometerUnits: BarometerUnits) = when (barometerUnits) {
        BarometerUnits.Hectopascals -> value < 1013
        BarometerUnits.MercuryСolumn -> value < 760
    }

    private fun getUviType(value: Float) = when (value) {
        in 0f..<3f -> ForecastCurrentUviType.Low
        in 3f..<5f -> ForecastCurrentUviType.Moderate
        in 5f..<7f -> ForecastCurrentUviType.High
        in 7f..10f -> ForecastCurrentUviType.VeryHigh
        else -> ForecastCurrentUviType.Extreme
    }

    private fun timeMapper(unix: Long): String {
        val instant = Instant.ofEpochSecond(unix)
        val formatter = DateTimeFormatter.ofPattern("HH:mm").withZone(ZoneId.systemDefault())
        return formatter.format(instant)
    }

    private fun mapPressure(value: Int, units: BarometerUnits) = if (units == BarometerUnits.MercuryСolumn) {
        (value.toFloat() * 0.75f).roundToInt()
    } else {
        value
    }
}
