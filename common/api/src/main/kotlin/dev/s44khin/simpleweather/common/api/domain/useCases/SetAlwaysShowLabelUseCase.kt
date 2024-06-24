package dev.s44khin.simpleweather.common.api.domain.useCases

interface SetAlwaysShowLabelUseCase {

    suspend fun execute(alwaysShowLabel: Boolean)
}