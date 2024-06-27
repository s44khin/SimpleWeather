package dev.s44khin.simpleweather.common.data.mappers

import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrent
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentPressure
import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrentWeather
import dev.s44khin.simpleweather.common.api.domain.model.TempUnits
import dev.s44khin.simpleweather.common.data.model.ForecastResponse

internal class ForecastMapper {

    fun map(response: ForecastResponse, tempUnits: TempUnits) = Forecast(
        timezone = response.timezone,
        current = ForecastCurrent(
            temp = formatTemp(
                value = response.current.temp,
                units = tempUnits,
            ),
            feelsLike = formatTemp(
                value = response.current.feelsLike,
                units = tempUnits,
            ),
            min = response.daily.getOrNull(0)?.let {
                formatTemp(
                    value = it.temp.min,
                    units = tempUnits,
                )
            },
            max = response.daily.getOrNull(0)?.let {
                formatTemp(
                    value = it.temp.max,
                    units = tempUnits,
                )
            },
            pressure = ForecastCurrentPressure(
                value = response.current.pressure,
                isLow = pressureIsLow(response.current.pressure)
            ),
            humidity = response.current.humidity,
            iconId = response.current.weather[0].icon,
            weather = response.current.weather[0].let {
                ForecastCurrentWeather(
                    main = it.main,
                    description = it.description.replaceFirstChar { it.uppercaseChar() },
                )
            }
        )
    )

    private fun formatTemp(value: String, units: TempUnits): String {
        return (value.toDoubleOrNull()?.toInt()?.toString() ?: "NoN") + units.symbol
    }

    private fun pressureIsLow(value: Int) = value < 1013
}
