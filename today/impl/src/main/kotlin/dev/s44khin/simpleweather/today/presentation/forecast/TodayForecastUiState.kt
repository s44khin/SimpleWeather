package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.runtime.Immutable
import dev.s44khin.simpleweather.common.api.presentation.model.BarometerUnitsVo
import dev.s44khin.simpleweather.common.api.presentation.model.ScreenModeVo
import dev.s44khin.simpleweather.common.api.presentation.model.UnitsVo
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo

@Immutable
internal data class TodayForecastUiState(
    val screenMode: ScreenModeVo = ScreenModeVo.Loading,
    val current: ForecastCurrentVo? = null,
    val isRefreshing: Boolean = false,
    val units: UnitsVo,
    val barometerUnits: BarometerUnitsVo
)
