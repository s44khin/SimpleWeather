package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class IsResetSettingsAvailableUseCase(
    private val repository: CommonRepository
) {

    fun execute() = with(repository) {
        unitsFlow.value.isNotDefault || colorFlow.value.isNotDefault || themeFlow.value.isNotDefault ||
                transparentFlow.value != true || alwaysShowLabelFlow.value != false
    }
}