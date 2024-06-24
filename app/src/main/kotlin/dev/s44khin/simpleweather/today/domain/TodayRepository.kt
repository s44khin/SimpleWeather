package dev.s44khin.simpleweather.today.domain

import dev.s44khin.simpleweather.today.data.remote.TodayRemote

class TodayRepository(
    private val todayRemote: TodayRemote,
) {

    suspend fun getTodayWeather() = todayRemote.getTodayWeather()
}