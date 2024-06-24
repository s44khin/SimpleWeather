package dev.s44khin.simpleweather.today.api.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Today
import dev.s44khin.simpleweather.navigation.api.NavDestination
import dev.s44khin.simpleweather.navigation.api.NavRootDestination
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.NativeText

object TodayNavigation : NavRootDestination {

    override val route = "today"

    override val label = NativeText.Resource(CoreStrings.today_label)

    override val icon = Icons.Rounded.Today

    override val startDestination = Forecast

    object Forecast : NavDestination {

        override val route = "${TodayNavigation.route}/forecast"
    }

    object SearchDialog : NavDestination {

        override val route = "${TodayNavigation.route}/search_dialog"
    }
}
