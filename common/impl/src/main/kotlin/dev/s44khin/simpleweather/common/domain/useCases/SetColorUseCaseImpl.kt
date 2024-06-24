package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.useCases.SetColorUseCase

class SetColorUseCaseImpl(
    private val repository: CommonRepository
) : SetColorUseCase {

    override suspend fun execute(color: PrimaryColor) {
        repository.setColor(color)
    }
}