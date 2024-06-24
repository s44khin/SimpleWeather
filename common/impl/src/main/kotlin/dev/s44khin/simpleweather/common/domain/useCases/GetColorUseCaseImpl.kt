package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetColorUseCase

internal class GetColorUseCaseImpl(
    private val repository: CommonRepository
) : GetColorUseCase {

    override fun execute() = repository.colorFlow.value
}