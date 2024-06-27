package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.common.api.domain.useCases.SetUnitsUseCase

internal class SetUnitsUseCaseImpl(
    private val repository: CommonRepository,
) : SetUnitsUseCase {

    override suspend fun execute(units: Units) {
        repository.setUnits(units)
    }
}