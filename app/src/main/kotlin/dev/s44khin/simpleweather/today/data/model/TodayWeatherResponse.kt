package dev.s44khin.simpleweather.today.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodayWeatherResponse(

    @SerialName(value = "name")
    val name: String,
)
