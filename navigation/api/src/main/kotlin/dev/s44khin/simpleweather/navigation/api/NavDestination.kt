package dev.s44khin.simpleweather.navigation.api

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
