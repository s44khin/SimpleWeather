package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetUnitsUseCase

class GetUnitsUseCaseImpl(
    private val repository: CommonRepository
) : GetUnitsUseCase {

    override fun execute() = repository.unitsFlow.value
}