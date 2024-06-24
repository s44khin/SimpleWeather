package dev.s44khin.simpleweather.today.domain.useCases

import dev.s44khin.simpleweather.today.domain.TodayRepository

class GetTodayWeatherUseCase(
    private val repository: TodayRepository,
) {

    suspend fun execute() = repository.getTodayWeather()
}