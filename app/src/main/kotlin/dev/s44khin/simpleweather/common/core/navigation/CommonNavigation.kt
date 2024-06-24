package dev.s44khin.simpleweather.common.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogScreen
import dev.s44khin.simpleweather.navigation.api.bottomSheet

object CommonNavigation {

    object ConfirmationDialog : dev.s44khin.simpleweather.navigation.api.NavDestination {

        override val route = "confirmation_dialog"
    }
}

fun NavGraphBuilder.commonNavigation() {
    bottomSheet(destination = CommonNavigation.ConfirmationDialog) {
        ConfirmationDialogScreen()
    }
}
