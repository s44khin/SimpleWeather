package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.useCases.SetThemeUseCase

class SetThemeUseCaseImpl(
    private val repository: CommonRepository
) : SetThemeUseCase {

    override suspend fun execute(theme: Theme) = repository.setTheme(theme)
}