package dev.s44khin.simpleweather.common.presentation.searchDialog

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.presentation.model.SearchLocationVo

@Immutable
data class SearchDialogUiState(
    val query: String,
    val result: List<SearchLocationVo>
)
