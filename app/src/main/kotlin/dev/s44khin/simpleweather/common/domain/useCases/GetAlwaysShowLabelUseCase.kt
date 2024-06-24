package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class GetAlwaysShowLabelUseCase(
    private val repository: CommonRepository
) {

    fun execute() = repository.alwaysShowLabelFlow.value
}