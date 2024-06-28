package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetBarometerUnitsUseCase

internal class GetBarometerUnitsUseCaseImpl(
    private val repository: CommonRepository
) : GetBarometerUnitsUseCase {

    override fun execute() = repository.barometerUnitsFlow.value
}
