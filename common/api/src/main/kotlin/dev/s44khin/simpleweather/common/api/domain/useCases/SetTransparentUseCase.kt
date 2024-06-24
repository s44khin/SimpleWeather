package dev.s44khin.simpleweather.common.api.domain.useCases

interface SetTransparentUseCase {

    suspend fun execute(transparent: Boolean)
}