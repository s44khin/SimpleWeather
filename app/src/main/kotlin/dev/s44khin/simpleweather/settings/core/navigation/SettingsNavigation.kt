package dev.s44khin.simpleweather.settings.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.navigation.api.NavDestination
import dev.s44khin.simpleweather.navigation.api.NavRootDestination
import dev.s44khin.simpleweather.navigation.api.composable
import dev.s44khin.simpleweather.navigation.api.navigation
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.settings.presentation.SettingsListScreen
import dev.s44khin.simpleweather.utils.NativeText

object SettingsNavigation : NavRootDestination {

    override val route = "settings"

    override val label = NativeText.Resource(CoreStrings.settings_label)

    override val icon = Icons.Rounded.Settings

    override val startDestination = List

    object List : NavDestination {

        const val RESET_CONFIRM_BUTTON_KEY = "reset_confirm_button_key"

        override val route = "${SettingsNavigation.route}/list"
    }
}

fun NavGraphBuilder.settingsNavigation() {
    navigation(rootDestination = SettingsNavigation) {
        composable(destination = SettingsNavigation.List) {
            SettingsListScreen()
        }
    }
}