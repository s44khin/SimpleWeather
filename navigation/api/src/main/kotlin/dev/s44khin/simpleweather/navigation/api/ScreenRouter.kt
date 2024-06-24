package dev.s44khin.simpleweather.navigation.api

import kotlinx.coroutines.flow.SharedFlow

interface ScreenRouter {
    val navigationCommands: SharedFlow<NavigationCommand>
    val signalsFlow: SharedFlow<String>

    fun navigateTo(navDestination: NavDestination)

    fun navigateBack(signal: String? = null)
}