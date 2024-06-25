package dev.s44khin.simpleweather.common.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ForecastResponse(

    @SerialName(value = "timezone")
    val timezone: String,

    @SerialName(value = "current")
    val current: ForecastCurrentDto,
)

@Serializable
internal data class ForecastCurrentDto(

    @SerialName(value = "temp")
    val temp: String,

    @SerialName(value = "feels_like")
    val feelsLike: String,

    @SerialName(value = "weather")
    val weather: List<ForecastCurrentWeather>,
)

@Serializable
internal data class ForecastCurrentWeather(

    @SerialName(value = "main")
    val main: String,

    @SerialName(value = "description")
    val description: String,
)
