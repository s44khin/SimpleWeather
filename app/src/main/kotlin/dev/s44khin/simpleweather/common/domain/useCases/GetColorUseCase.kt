package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class GetColorUseCase(
    private val repository: CommonRepository
) {

    fun execute() = repository.colorFlow.value
}