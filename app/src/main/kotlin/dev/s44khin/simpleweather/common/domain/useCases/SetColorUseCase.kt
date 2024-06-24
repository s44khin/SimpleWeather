package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor

class SetColorUseCase(
    private val repository: CommonRepository
) {

    suspend fun execute(color: PrimaryColor) {
        repository.setColor(color)
    }
}