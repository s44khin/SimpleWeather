package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import javax.inject.Inject

class GetColorUseCase @Inject constructor(
    private val repository: CommonRepository
) {

    fun execute() = repository.colorFlow.value
}