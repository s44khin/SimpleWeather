package dev.s44khin.simpleweather.common.api.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.model.SearchLocation

interface SearchLocationUseCase {

    suspend fun execute(name: String): List<SearchLocation>
}