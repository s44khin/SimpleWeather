package dev.s44khin.simpleweather.today.presentation.forecast

sealed class TodayForecastAction {

    data object OnSearchClicked : TodayForecastAction()
}