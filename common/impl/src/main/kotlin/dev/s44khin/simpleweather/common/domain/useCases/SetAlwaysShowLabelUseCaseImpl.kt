package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.SetAlwaysShowLabelUseCase

class SetAlwaysShowLabelUseCaseImpl(
    private val repository: CommonRepository
) : SetAlwaysShowLabelUseCase {

    override suspend fun execute(alwaysShowLabel: Boolean) = repository.setAlwaysShowLabel(alwaysShowLabel)
}