package dev.s44khin.simpleweather.core.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
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