package dev.s44khin.simpleweather.today.presentation.forecast

import dev.s44khin.simpleweather.common.api.domain.model.ForecastCurrent

internal data class TodayForecastScreenState(
    val locationName: String? = null,
    val current: ForecastCurrent? = null,
    val isRefreshing: Boolean = false,
)
