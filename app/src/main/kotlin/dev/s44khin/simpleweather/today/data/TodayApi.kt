package dev.s44khin.simpleweather.today.data

import dev.s44khin.simpleweather.today.data.model.TodayWeatherResponse
import retrofit2.http.GET

interface TodayApi {

    @GET("2.5/weather?lat=52.17&lon=104.18")
    suspend fun getTodayWeather(): TodayWeatherResponse
}
