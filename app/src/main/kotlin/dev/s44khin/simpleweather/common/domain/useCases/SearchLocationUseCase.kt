package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository

class SearchLocationUseCase(
    private val repository: CommonRepository,
) {

    suspend fun execute(name: String) = repository.searchLocation(name)
}