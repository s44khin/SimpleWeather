package dev.s44khin.simpleweather.week.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ViewWeek
import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.NavRootDestination
import dev.s44khin.simpleweather.core.navigation.composable
import dev.s44khin.simpleweather.core.navigation.navigation
import dev.s44khin.simpleweather.uikit.util.NativeText
import dev.s44khin.simpleweather.week.forecast.WeekForecastScreen

object WeekNavigation : NavRootDestination {

    override val route = "week"

    override val label = NativeText.Resource(R.string.week_label)

    override val icon = Icons.Rounded.ViewWeek

    override val startDestination = Forecast

    object Forecast : NavDestination {

        override val route = "${WeekNavigation.route}/forecast"
    }
}

fun NavGraphBuilder.weekNavigation() {
    navigation(rootDestination = WeekNavigation) {
        composable(destination = WeekNavigation.Forecast) {
            WeekForecastScreen()
        }
    }
}