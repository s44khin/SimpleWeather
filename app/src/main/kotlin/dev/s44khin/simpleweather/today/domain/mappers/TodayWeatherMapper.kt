package dev.s44khin.simpleweather.today.domain.mappers

import dev.s44khin.simpleweather.today.data.model.TodayWeatherResponse
import dev.s44khin.simpleweather.today.domain.model.TodayWeather
import javax.inject.Inject

class TodayWeatherMapper @Inject constructor() {

    fun map(response: TodayWeatherResponse) = TodayWeather(
        name = response.name,
    )
}