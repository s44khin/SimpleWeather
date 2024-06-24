package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.Theme

class SetThemeUseCase(
    private val repository: CommonRepository
) {

    suspend fun execute(theme: Theme) = repository.setTheme(theme)
}