package dev.s44khin.simpleweather.main

import dev.s44khin.simpleweather.navigation.api.NavRootDestination

internal sealed class MainAction {

    data class OnBottomNavigationClicked(val navDestination: NavRootDestination) : MainAction()
}