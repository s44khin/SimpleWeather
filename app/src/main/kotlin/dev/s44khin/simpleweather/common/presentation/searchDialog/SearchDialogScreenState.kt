package dev.s44khin.simpleweather.common.presentation.searchDialog

import dev.s44khin.simpleweather.common.domain.model.SearchLocation

data class SearchDialogScreenState(
    val query: String = "",
    val result: List<SearchLocation> = emptyList(),
)
