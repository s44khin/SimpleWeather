package dev.s44khin.simpleweather.common.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
internal data class SearchLocationVo(
    val name: String,
    val localNames: SearchLocationLocalNamesVo,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String?,
)

@Immutable
internal data class SearchLocationLocalNamesVo(
    val ru: String,
    val en: String,
)