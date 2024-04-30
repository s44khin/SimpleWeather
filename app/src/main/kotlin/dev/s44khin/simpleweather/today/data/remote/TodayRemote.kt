package dev.s44khin.simpleweather.today.data.remote

import dev.s44khin.simpleweather.today.data.TodayApi
import dev.s44khin.simpleweather.today.domain.mappers.TodayWeatherMapper
import javax.inject.Inject

class TodayRemote @Inject constructor(
    private val todayApi: TodayApi,
    private val todayWeatherMapper: TodayWeatherMapper,
) {

    suspend fun getTodayWeather() = todayWeatherMapper.map(
        response = todayApi.getTodayWeather()
    )
}