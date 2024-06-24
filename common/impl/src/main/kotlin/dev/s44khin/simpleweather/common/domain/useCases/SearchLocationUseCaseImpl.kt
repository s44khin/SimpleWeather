package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.SearchLocationUseCase

class SearchLocationUseCaseImpl(
    private val repository: CommonRepository,
) : SearchLocationUseCase {

    override suspend fun execute(name: String) = repository.searchLocation(name)
}