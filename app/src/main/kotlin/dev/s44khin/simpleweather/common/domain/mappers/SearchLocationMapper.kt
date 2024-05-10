package dev.s44khin.simpleweather.common.domain.mappers

import dev.s44khin.simpleweather.common.data.model.GetLocationByNameResponse
import dev.s44khin.simpleweather.common.domain.model.SearchLocation
import dev.s44khin.simpleweather.common.domain.model.SearchLocationLocalNames
import javax.inject.Inject

class SearchLocationMapper @Inject constructor() {

    fun map(response: List<GetLocationByNameResponse>) = response.map {
        SearchLocation(
            name = it.name,
            lat = it.lat,
            lon = it.lon,
            country = it.country,
            state = it.state,
            localNames = SearchLocationLocalNames(
                ru = it.localNames?.ru ?: it.name,
                en = it.localNames?.en ?: it.name,
            )
        )
    }
}