package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.Units

interface GetUnitsUseCase {

    fun execute(): Units
}