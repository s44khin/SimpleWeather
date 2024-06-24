package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class GetThemeUseCase(
    private val repository: CommonRepository
) {

    fun execute() = repository.themeFlow.value
}