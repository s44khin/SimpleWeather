package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetForecastUseCase

internal class GetForecastUseCaseImpl(
    private val repository: CommonRepository,
) : GetForecastUseCase {

    override suspend fun execute() = repository.getAllWeather(
        tempUnits = repository.unitsFlow.value
    )
}