package dev.s44khin.simpleweather.today.presentation.forecast

internal sealed class TodayForecastAction {

    data object OnSearchClicked : TodayForecastAction()
}