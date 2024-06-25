package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo

@Immutable
internal data class TodayForecastUiState(
    val locationName: String? = null,
    val current: ForecastCurrentVo? = null,
    val isRefreshing: Boolean = false,
)