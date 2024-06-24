package dev.s44khin.simpleweather.today.data.remote

import dev.s44khin.simpleweather.core.network.getBody
import dev.s44khin.simpleweather.today.domain.mappers.TodayWeatherMapper
import io.ktor.client.HttpClient

class TodayRemote(
    private val client: HttpClient,
    private val todayWeatherMapper: TodayWeatherMapper,
) {

    suspend fun getTodayWeather() = todayWeatherMapper.map(
        response = client.getBody("data/2.5/weather?lat=52.17&lon=104.18")
    )
}