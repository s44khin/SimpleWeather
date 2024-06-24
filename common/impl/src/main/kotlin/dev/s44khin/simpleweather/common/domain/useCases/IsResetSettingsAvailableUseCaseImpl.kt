package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.IsResetSettingsAvailableUseCase

internal class IsResetSettingsAvailableUseCaseImpl(
    private val repository: CommonRepository
) : IsResetSettingsAvailableUseCase {

    override fun execute() = with(repository) {
        unitsFlow.value.isNotDefault || colorFlow.value.isNotDefault || themeFlow.value.isNotDefault ||
                transparentFlow.value != true || alwaysShowLabelFlow.value != false
    }
}