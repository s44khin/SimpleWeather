package dev.s44khin.simpleweather.today.presentation.forecast

import javax.inject.Inject

class TodayForecastConverter @Inject constructor() {

    fun convert(screenState: TodayForecastScreenState) = TodayForecastUiState
}