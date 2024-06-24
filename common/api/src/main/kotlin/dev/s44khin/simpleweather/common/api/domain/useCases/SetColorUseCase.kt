package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor

interface SetColorUseCase {

    suspend fun execute(color: PrimaryColor)
}