package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : ViewModel() {

    val navigationCommand = screenRouter.navigationCommand

    fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked -> onBottomNavigationClicked(action.navDestination)
    }

    private fun onBottomNavigationClicked(navDestination: NavDestination) {
        screenRouter.navigateTo(navDestination)
    }
}
