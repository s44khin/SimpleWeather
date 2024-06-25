package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.runtime.Immutable

@Immutable
internal data class TodayForecastUiState(
    val locationName: String? = null,
)