package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.useCases.SetBarometerUnitsUseCase

internal class SetBarometerUnitsUseCaseImpl(
    private val repository: CommonRepository,
) : SetBarometerUnitsUseCase {

    override suspend fun execute(units: BarometerUnits) {
        repository.setBarometerUnits(units)
    }
}