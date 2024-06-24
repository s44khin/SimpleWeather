package dev.s44khin.simpleweather.week.api.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ViewWeek
import dev.s44khin.simpleweather.navigation.api.NavDestination
import dev.s44khin.simpleweather.navigation.api.NavRootDestination
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.NativeText

object WeekNavigation : NavRootDestination {

    override val route = "week"

    override val label = NativeText.Resource(CoreStrings.week_label)

    override val icon = Icons.Rounded.ViewWeek

    override val startDestination = Forecast

    object Forecast : NavDestination {

        override val route = "${WeekNavigation.route}/forecast"
    }
}