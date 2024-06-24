package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.TempUnits
import dev.s44khin.simpleweather.common.api.domain.useCases.SetUnitsUseCase

internal class SetUnitsUseCaseImpl(
    private val repository: CommonRepository,
) : SetUnitsUseCase {

    override suspend fun execute(units: TempUnits) {
        repository.setUnits(units)
    }
}