package dev.s44khin.simpleweather.core.main

import dev.s44khin.simpleweather.core.navigation.NavRootDestination

sealed class MainAction {

    data class OnBottomNavigationClicked(val navDestination: NavRootDestination) : MainAction()
}