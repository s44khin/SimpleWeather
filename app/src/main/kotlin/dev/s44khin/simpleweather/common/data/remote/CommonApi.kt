package dev.s44khin.simpleweather.common.data.remote

import dev.s44khin.simpleweather.common.data.model.GetLocationByNameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CommonApi {

    private companion object {
        private const val LIMIT = 5
    }

    @GET("geo/1.0/direct?limit=$LIMIT")
    suspend fun getLocationByName(
        @Query("q") name: String
    ): List<GetLocationByNameResponse>
}