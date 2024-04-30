package dev.s44khin.simpleweather.core.navigation

sealed class NavigationCommand {

    data class NavigateTo(val navDestination: NavDestination) : NavigationCommand()
    data object NavigateBack : NavigationCommand()
}