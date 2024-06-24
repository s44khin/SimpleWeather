package dev.s44khin.simpleweather.settings.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.navigation.api.composable
import dev.s44khin.simpleweather.navigation.api.navigation
import dev.s44khin.simpleweather.settings.api.navigation.SettingsNavigation
import dev.s44khin.simpleweather.settings.presentation.SettingsListScreen

fun NavGraphBuilder.settingsNavigation() {
    navigation(rootDestination = SettingsNavigation) {
        composable(destination = SettingsNavigation.List) {
            SettingsListScreen()
        }
    }
}