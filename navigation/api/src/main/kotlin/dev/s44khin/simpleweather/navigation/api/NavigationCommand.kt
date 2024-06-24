package dev.s44khin.simpleweather.navigation.api

sealed class NavigationCommand {

    data class NavigateTo(val navDestination: NavDestination) : NavigationCommand()
    data object NavigateBack : NavigationCommand()
}