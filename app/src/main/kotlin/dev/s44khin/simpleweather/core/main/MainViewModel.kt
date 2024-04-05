package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.ViewModel
import dev.s44khin.simpleweather.core.navigation.NavRootDestination
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : ViewModel() {

    fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked -> onBottomNavigationClicked(action.navRootDestination)
    }

    private fun onBottomNavigationClicked(navRootDestination: NavRootDestination) {
        screenRouter.navigateTo(navRootDestination)
    }
}
