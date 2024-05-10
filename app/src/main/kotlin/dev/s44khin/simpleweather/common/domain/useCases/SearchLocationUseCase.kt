package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import javax.inject.Inject

class SearchLocationUseCase @Inject constructor(
    private val repository: CommonRepository,
) {

    suspend fun execute(name: String) = repository.searchLocation(name)
}