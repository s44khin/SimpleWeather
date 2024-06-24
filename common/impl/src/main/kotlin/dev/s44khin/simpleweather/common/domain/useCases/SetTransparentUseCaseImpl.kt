package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.SetTransparentUseCase

class SetTransparentUseCaseImpl(
    private val repository: CommonRepository
) : SetTransparentUseCase {

    override suspend fun execute(transparent: Boolean) = repository.setTransparent(transparent)
}