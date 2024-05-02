package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.Theme
import javax.inject.Inject

class SetThemeUseCase @Inject constructor(
    private val repository: CommonRepository
) {

    suspend fun execute(theme: Theme) = repository.setTheme(theme)
}