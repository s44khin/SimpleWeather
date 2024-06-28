package dev.s44khin.simpleweather.common.data.remote

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.common.data.mappers.ForecastMapper
import dev.s44khin.simpleweather.common.data.mappers.SearchLocationMapper
import dev.s44khin.simpleweather.core.network.getBody
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter

internal class CommonRemote(
    private val client: HttpClient,
    private val searchLocationMapper: SearchLocationMapper,
    private val forecastMapper: ForecastMapper
) {

    suspend fun searchLocation(name: String) = searchLocationMapper.map(
        response = client.getBody("geo/1.0/direct") {
            parameter(key = "limit", value = 5)
            parameter(key = "q", value = name)
        }
    )

    suspend fun getForecast(tempUnits: Units, barometerUnits: BarometerUnits) = forecastMapper.map(
        response = client.getBody("data/3.0/onecall") {
            parameter(key = "lat", value = "52.17")
            parameter(key = "lon", value = "104.18")
            parameter(key = "units", value = tempUnits.name)
        },
        barometerUnits = barometerUnits,
    )
}
