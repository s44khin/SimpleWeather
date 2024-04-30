package dev.s44khin.simpleweather.core.navigation

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityRetainedScoped
class ScreenRouter @Inject constructor() {

    private val routerScope = CoroutineScope(Dispatchers.Main.immediate)

    private val _navigationCommands = MutableSharedFlow<NavigationCommand>()
    val navigationCommand = _navigationCommands.asSharedFlow()

    fun navigateTo(navDestination: NavDestination) {
        routerScope.launch {
            _navigationCommands.emit(
                value = NavigationCommand.NavigateTo(
                    navDestination = navDestination
                )
            )
        }
    }

    fun navigateBack() {
        routerScope.launch {
            _navigationCommands.emit(
                value = NavigationCommand.NavigateBack
            )
        }
    }
}