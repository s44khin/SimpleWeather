package dev.s44khin.simpleweather.today.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.navigation.api.composable
import dev.s44khin.simpleweather.navigation.api.navigation
import dev.s44khin.simpleweather.today.api.navigation.TodayNavigation
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastScreen

fun NavGraphBuilder.todayNavigation() {
    navigation(rootDestination = TodayNavigation) {
        composable(destination = TodayNavigation.Forecast) {
            TodayForecastScreen()
        }
    }
}
