package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class SetAlwaysShowLabelUseCase(
    private val repository: CommonRepository
) {

    suspend fun execute(alwaysShowLabel: Boolean) = repository.setAlwaysShowLabel(alwaysShowLabel)
}