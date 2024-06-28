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

    @SerialName(value = "hourly")
    val hourly: List<ForecastHourlyItemDto>,
)

@Serializable
internal data class ForecastCurrentDto(

    @SerialName(value = "dt")
    val dt: Long,

    @SerialName(value = "temp")
    val temp: String,

    @SerialName(value = "feels_like")
    val feelsLike: String,

    @SerialName(value = "weather")
    val weather: List<ForecastCurrentWeatherDto>,

    @SerialName(value = "humidity")
    val humidity: String,

    @SerialName(value = "pressure")
    val pressure: Int,

    @SerialName(value = "uvi")
    val uvi: Float,

    @SerialName(value = "wind_speed")
    val windSpeed: Float,

    @SerialName(value = "wind_deg")
    val windDegree: Float,

    @SerialName(value = "wind_gust")
    val windGust: Float? = null,

    @SerialName(value = "sunrise")
    val sunrise: Long,

    @SerialName(value = "sunset")
    val sunset: Long,
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

@Serializable
internal data class ForecastHourlyItemDto(

    @SerialName(value = "pop")
    val pop: Float,

    @SerialName(value = "rain")
    val rain: ForecastHourlyRainSnow? = null,

    @SerialName(value = "snow")
    val snow: ForecastHourlyRainSnow? = null,
)

@Serializable
internal data class ForecastHourlyRainSnow(

    @SerialName(value = "1h")
    val value: Float? = null,
)
