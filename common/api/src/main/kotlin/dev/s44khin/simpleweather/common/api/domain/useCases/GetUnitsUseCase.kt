package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.TempUnits

interface GetUnitsUseCase {

    fun execute(): TempUnits
}