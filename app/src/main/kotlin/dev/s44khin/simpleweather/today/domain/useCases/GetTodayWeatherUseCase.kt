package dev.s44khin.simpleweather.today.domain.useCases

import dev.s44khin.simpleweather.today.domain.TodayRepository
import javax.inject.Inject

class GetTodayWeatherUseCase @Inject constructor(
    private val repository: TodayRepository,
) {

    suspend fun execute() = repository.getTodayWeather()
}