package dev.s44khin.simpleweather.common.data.mappers

import dev.s44khin.simpleweather.common.api.domain.model.SearchLocation
import dev.s44khin.simpleweather.common.api.domain.model.SearchLocationLocalNames
import dev.s44khin.simpleweather.common.data.model.GetLocationByNameResponse

internal class SearchLocationMapper {

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