package dev.s44khin.simpleweather.common.presentation.searchDialog

import dev.s44khin.simpleweather.common.api.domain.model.SearchLocation

internal data class SearchDialogScreenState(
    val query: String = "",
    val result: List<SearchLocation> = emptyList(),
)
