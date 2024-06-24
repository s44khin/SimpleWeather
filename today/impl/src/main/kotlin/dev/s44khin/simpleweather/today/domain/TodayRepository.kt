package dev.s44khin.simpleweather.today.domain

import dev.s44khin.simpleweather.today.data.remote.TodayRemote

internal class TodayRepository(
    private val todayRemote: TodayRemote,
) {

    suspend fun getTodayWeather() = todayRemote.getTodayWeather()
}