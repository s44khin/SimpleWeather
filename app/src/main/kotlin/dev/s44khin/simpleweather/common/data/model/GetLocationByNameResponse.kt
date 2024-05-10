package dev.s44khin.simpleweather.common.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetLocationByNameResponse(

    @Json(name = "name")
    val name: String,

    @Json(name = "local_names")
    val localNames: GetLocationByNameLocalNamesDto?,

    @Json(name = "lat")
    val lat: String,

    @Json(name = "lon")
    val lon: String,

    @Json(name = "country")
    val country: String,

    @Json(name = "state")
    val state: String?,
)

@JsonClass(generateAdapter = true)
data class GetLocationByNameLocalNamesDto(

    @Json(name = "ru")
    val ru: String,

    @Json(name = "en")
    val en: String,
)
