package dev.s44khin.simpleweather.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.utils.NativeText

interface NavDestination {

    val route: String
}

interface NavRootDestination : NavDestination {

    val startDestination: NavDestination

    val icon: ImageVector

    val label: NativeText
}
