package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.Theme

interface SetThemeUseCase {

    suspend fun execute(theme: Theme)
}