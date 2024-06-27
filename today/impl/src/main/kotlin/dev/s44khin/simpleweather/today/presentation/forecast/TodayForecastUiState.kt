package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.model.ScreenModeVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo

@Immutable
internal data class TodayForecastUiState(
    val screenMode: ScreenModeVo = ScreenModeVo.Loading,
    val locationName: String? = null,
    val current: ForecastCurrentVo? = null,
    val isRefreshing: Boolean = false,
)
