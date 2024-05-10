package dev.s44khin.simpleweather.common.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
data class SearchLocationVo(
    val name: String,
    val localNames: SearchLocationLocalNamesVo,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String?,
)

@Immutable
data class SearchLocationLocalNamesVo(
    val ru: String,
    val en: String,
)