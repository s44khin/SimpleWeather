package dev.s44khin.simpleweather.common.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ForecastResponse(

    @SerialName(value = "timezone")
    val timezone: String,

    @SerialName(value = "current")
    val current: ForecastCurrentDto,

    @SerialName(value = "daily")
    val daily: List<ForecastDailyItemDto>,
)

@Serializable
internal data class ForecastCurrentDto(

    @SerialName(value = "temp")
    val temp: String,

    @SerialName(value = "feels_like")
    val feelsLike: String,

    @SerialName(value = "weather")
    val weather: List<ForecastCurrentWeatherDto>,
)

@Serializable
internal data class ForecastCurrentWeatherDto(

    @SerialName(value = "main")
    val main: String,

    @SerialName(value = "description")
    val description: String,

    @SerialName(value = "icon")
    val icon: String,
)

@Serializable
internal data class ForecastDailyItemDto(

    @SerialName(value = "temp")
    val temp: ForecastTempDto,
)

@Serializable
internal data class ForecastTempDto(

    @SerialName(value = "min")
    val min: String,

    @SerialName(value = "max")
    val max: String,
)
