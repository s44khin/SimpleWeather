package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import javax.inject.Inject

class SetAlwaysShowLabelUseCase @Inject constructor(
    private val repository: CommonRepository
) {

    suspend fun execute(alwaysShowLabel: Boolean) = repository.setAlwaysShowLabel(alwaysShowLabel)
}