package dev.s44khin.simpleweather.week.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.navigation.api.composable
import dev.s44khin.simpleweather.navigation.api.navigation
import dev.s44khin.simpleweather.week.api.navigation.WeekNavigation
import dev.s44khin.simpleweather.week.presentation.forecast.WeekForecastScreen

fun NavGraphBuilder.weekNavigation() {
    navigation(rootDestination = WeekNavigation) {
        composable(destination = WeekNavigation.Forecast) {
            WeekForecastScreen()
        }
    }
}
