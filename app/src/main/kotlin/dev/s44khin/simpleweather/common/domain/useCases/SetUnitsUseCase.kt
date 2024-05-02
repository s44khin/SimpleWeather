package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import javax.inject.Inject

class SetUnitsUseCase @Inject constructor(
    private val repository: CommonRepository,
) {

    suspend fun execute(units: TempUnits) {
        repository.setUnits(units)
    }
}