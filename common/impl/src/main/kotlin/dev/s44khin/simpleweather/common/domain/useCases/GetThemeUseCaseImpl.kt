package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetThemeUseCase

internal class GetThemeUseCaseImpl(
    private val repository: CommonRepository
) : GetThemeUseCase {

    override fun execute() = repository.themeFlow.value
}