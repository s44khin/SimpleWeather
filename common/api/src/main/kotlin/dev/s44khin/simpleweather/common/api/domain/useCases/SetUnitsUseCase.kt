package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.TempUnits

interface SetUnitsUseCase {

    suspend fun execute(units: TempUnits)
}