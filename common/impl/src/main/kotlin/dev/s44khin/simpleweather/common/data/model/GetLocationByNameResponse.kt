package dev.s44khin.simpleweather.common.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GetLocationByNameResponse(

    @SerialName(value = "name")
    val name: String,

    @SerialName(value = "local_names")
    val localNames: GetLocationByNameLocalNamesDto?,

    @SerialName(value = "lat")
    val lat: String,

    @SerialName(value = "lon")
    val lon: String,

    @SerialName(value = "country")
    val country: String,

    @SerialName(value = "state")
    val state: String?,
)

@Serializable
internal data class GetLocationByNameLocalNamesDto(

    @SerialName(value = "ru")
    val ru: String,

    @SerialName(value = "en")
    val en: String,
)
