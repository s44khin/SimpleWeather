package dev.s44khin.simpleweather.common.data.remote

import dev.s44khin.simpleweather.common.domain.mappers.SearchLocationMapper
import dev.s44khin.simpleweather.common.util.getBody
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import javax.inject.Inject

class CommonRemote @Inject constructor(
    private val client: HttpClient,
    private val searchLocationMapper: SearchLocationMapper,
) {

    suspend fun searchLocation(name: String) = searchLocationMapper.map(
        response = client.getBody("geo/1.0/direct") {
            parameter(key = "limit", value = 5)
            parameter(key = "q", value = name)
        }
    )
}
