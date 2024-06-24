package dev.s44khin.simpleweather.main

import dev.s44khin.simpleweather.navigation.api.NavRootDestination

sealed class MainAction {

    data class OnBottomNavigationClicked(val navDestination: NavRootDestination) : MainAction()
}