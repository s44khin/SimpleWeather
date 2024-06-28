package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits

interface GetBarometerUnitsUseCase {

    fun execute(): BarometerUnits
}