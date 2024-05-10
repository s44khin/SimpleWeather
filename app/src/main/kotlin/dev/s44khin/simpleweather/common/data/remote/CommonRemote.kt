package dev.s44khin.simpleweather.common.data.remote

import dev.s44khin.simpleweather.common.domain.mappers.SearchLocationMapper
import javax.inject.Inject

class CommonRemote @Inject constructor(
    private val api: CommonApi,
    private val searchLocationMapper: SearchLocationMapper,
) {

    suspend fun searchLocation(name: String) = searchLocationMapper.map(
        response = api.getLocationByName(name)
    )
}
