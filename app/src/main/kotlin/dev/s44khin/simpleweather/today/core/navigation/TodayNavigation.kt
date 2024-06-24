package dev.s44khin.simpleweather.today.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Today
import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogScreen
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.NavRootDestination
import dev.s44khin.simpleweather.core.navigation.composable
import dev.s44khin.simpleweather.core.navigation.navigation
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastScreen
import dev.s44khin.simpleweather.utils.NativeText

object TodayNavigation : NavRootDestination {

    override val route = "today"

    override val label = NativeText.Resource(R.string.today_label)

    override val icon = Icons.Rounded.Today

    override val startDestination = Forecast

    object Forecast : NavDestination {

        override val route = "${TodayNavigation.route}/forecast"
    }

    object SearchDialog : NavDestination {

        override val route = "${TodayNavigation.route}/search_dialog"
    }
}

fun NavGraphBuilder.todayNavigation() {
    navigation(rootDestination = TodayNavigation) {
        composable(destination = TodayNavigation.Forecast) {
            TodayForecastScreen()
        }

        composable(destination = TodayNavigation.SearchDialog) {
            SearchDialogScreen()
        }
    }
}