package dev.s44khin.simpleweather.common.api.domain.model

data class SearchLocation(
    val name: String,
    val localNames: SearchLocationLocalNames,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String?,
)

data class SearchLocationLocalNames(
    val ru: String,
    val en: String,
)