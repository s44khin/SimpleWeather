package dev.s44khin.simpleweather.core.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.composable(
    destination: NavDestination,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = content,
    )
}

fun NavGraphBuilder.bottomSheet(
    destination: NavDestination,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (backstackEntry: NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = { content(it) },
    )
}

fun NavGraphBuilder.navigation(
    rootDestination: NavRootDestination,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = rootDestination.startDestination.route,
        route = rootDestination.route,
        builder = builder,
    )
}

fun NavHostController.navigate(
    navDestination: NavDestination,
    builder: NavOptionsBuilder.() -> Unit
) = navigate(
    route = navDestination.route,
    builder = builder,
)