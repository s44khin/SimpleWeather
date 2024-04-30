package dev.s44khin.simpleweather.today.domain

import dev.s44khin.simpleweather.today.data.remote.TodayRemote
import javax.inject.Inject

class TodayRepository @Inject constructor(
    private val todayRemote: TodayRemote,
) {

    suspend fun getTodayWeather() = todayRemote.getTodayWeather()
}