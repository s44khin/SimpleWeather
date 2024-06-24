package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetAlwaysShowLabelUseCase

internal class GetAlwaysShowLabelUseCaseImpl(
    private val repository: CommonRepository
) : GetAlwaysShowLabelUseCase {

    override fun execute() = repository.alwaysShowLabelFlow.value
}