package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import javax.inject.Inject

class SetTransparentUseCase @Inject constructor(
    private val repository: CommonRepository
) {

    suspend fun execute(transparent: Boolean) = repository.setTransparent(transparent)
}