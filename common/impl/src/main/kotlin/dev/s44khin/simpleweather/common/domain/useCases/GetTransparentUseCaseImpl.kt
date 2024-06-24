package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetTransparentUseCase

class GetTransparentUseCaseImpl(
    private val repository: CommonRepository
) : GetTransparentUseCase {

    override fun execute() = repository.transparentFlow.value
}