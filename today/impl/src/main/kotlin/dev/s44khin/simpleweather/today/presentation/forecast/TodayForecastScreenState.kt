package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrent
import dev.s44khin.simpleweather.common.api.domain.model.ScreenMode
import dev.s44khin.simpleweather.common.api.domain.model.Units

internal data class TodayForecastScreenState(
    val mode: ScreenMode = ScreenMode.Loading,
    val locationName: String? = null,
    val current: ForecastCurrent? = null,
    val isRefreshing: Boolean = false,
    val units: Units = Units.Default,
) {

    fun toLoading() = copy(
        mode = ScreenMode.Loading,
    )

    fun toContent() = copy(
        mode = ScreenMode.Content,
    )

    fun toError() = copy(
        mode = ScreenMode.Error,
    )

    fun toP2R() = copy(
        isRefreshing = true,
    )
}
