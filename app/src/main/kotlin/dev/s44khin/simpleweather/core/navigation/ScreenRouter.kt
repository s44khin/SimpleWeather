package dev.s44khin.simpleweather.core.navigation

import androidx.navigation.NavHostController
import javax.inject.Inject

class ScreenRouter @Inject constructor(
    private val navHostController: NavHostController,
) {

    fun navigateTo(navDestination: NavDestination) {
        navHostController.navigate(route = navDestination.route)
    }

    fun navigateToRoot(navRootDestination: NavRootDestination) {
        navHostController.navigate(route = navRootDestination.route) {
            popUpTo(navRootDestination.startDestination.route)
            launchSingleTop = true
            restoreState = true
        }
    }
}
