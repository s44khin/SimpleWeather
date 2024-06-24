package dev.s44khin.simpleweather.today.domain.mappers

import dev.s44khin.simpleweather.today.data.model.TodayWeatherResponse
import dev.s44khin.simpleweather.today.domain.model.TodayWeather

internal class TodayWeatherMapper {

    fun map(response: TodayWeatherResponse) = TodayWeather(
        name = response.name,
    )
}