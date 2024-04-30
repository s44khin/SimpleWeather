package dev.s44khin.simpleweather.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun NavigationCommandHandler(
    navController: NavHostController,
    commands: SharedFlow<NavigationCommand>,
) {
    LaunchedEffect(Unit) {
        commands.collect { command ->
            when (command) {
                is NavigationCommand.NavigateBack -> navController.popBackStack()
                is NavigationCommand.NavigateTo -> navController.navigate(command.navDestination) {
                    if (command.navDestination is NavRootDestination) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }
}