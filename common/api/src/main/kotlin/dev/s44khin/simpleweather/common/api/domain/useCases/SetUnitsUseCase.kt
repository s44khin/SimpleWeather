package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.Units

interface SetUnitsUseCase {

    suspend fun execute(units: Units)
}