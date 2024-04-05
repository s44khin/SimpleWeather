package dev.s44khin.simpleweather.today.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Today
import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.NavRootDestination
import dev.s44khin.simpleweather.core.navigation.composable
import dev.s44khin.simpleweather.core.navigation.navigation
import dev.s44khin.simpleweather.today.forecast.TodayForecastScreen
import dev.s44khin.simpleweather.uikit.util.NativeText

object TodayNavigation : NavRootDestination {

    override val route = "today"

    override val label = NativeText.Resource(R.string.today_label)

    override val icon = Icons.Rounded.Today

    override val startDestination = Forecast

    object Forecast : NavDestination {

        override val route = "${TodayNavigation.route}/forecast"
    }
}

fun NavGraphBuilder.todayNavigation() {
    navigation(rootDestination = TodayNavigation) {
        composable(destination = TodayNavigation.Forecast) {
            TodayForecastScreen()
        }
    }
}