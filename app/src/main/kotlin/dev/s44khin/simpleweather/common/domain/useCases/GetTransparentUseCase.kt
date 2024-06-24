package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class GetTransparentUseCase(
    private val repository: CommonRepository
) {

    fun execute() = repository.transparentFlow.value
}