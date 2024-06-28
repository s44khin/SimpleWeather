package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits

interface SetBarometerUnitsUseCase {

    suspend fun execute(units: BarometerUnits)
}
