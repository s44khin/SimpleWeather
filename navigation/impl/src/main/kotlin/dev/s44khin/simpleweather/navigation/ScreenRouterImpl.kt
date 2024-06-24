package dev.s44khin.simpleweather.navigation

import dev.s44khin.simpleweather.navigation.api.NavDestination
import dev.s44khin.simpleweather.navigation.api.NavigationCommand
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

internal class ScreenRouterImpl : ScreenRouter {

    private val routerScope = CoroutineScope(Dispatchers.Main.immediate)

    override val navigationCommands = MutableSharedFlow<NavigationCommand>()

    override val signalsFlow = MutableSharedFlow<String>()

    override fun navigateTo(navDestination: NavDestination) {
        routerScope.launch {
            navigationCommands.emit(
                value = NavigationCommand.NavigateTo(
                    navDestination = navDestination
                )
            )
        }
    }

    override fun navigateBack(signal: String?) {
        routerScope.launch {
            if (signal != null) {
                signalsFlow.emit(signal)
            }

            navigationCommands.emit(
                value = NavigationCommand.NavigateBack
            )
        }
    }
}