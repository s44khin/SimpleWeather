package dev.s44khin.simpleweather.settings.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.NavRootDestination
import dev.s44khin.simpleweather.core.navigation.composable
import dev.s44khin.simpleweather.core.navigation.navigation
import dev.s44khin.simpleweather.settings.presentation.SettingsListScreen
import dev.s44khin.simpleweather.uikit.util.NativeText

object SettingsNavigation : NavRootDestination {

    override val route = "settings"

    override val label = NativeText.Resource(R.string.settings_label)

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