package dev.s44khin.simpleweather.core.main

sealed class MainAction {

    data class OnBottomNavigationClicked(val navDestination: dev.s44khin.simpleweather.navigation.api.NavRootDestination) :
        MainAction()
}