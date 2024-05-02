package dev.s44khin.simpleweather.common.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialog
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.bottomSheet

object CommonNavigation : NavDestination {

    override val route = "common"

    object ConfirmationDialog : NavDestination {

        override val route = "${CommonNavigation.route}/confirmation_dialog"
    }
}

fun NavGraphBuilder.commonNavigation() {
    bottomSheet(destination = CommonNavigation.ConfirmationDialog) {
        ConfirmationDialog()
    }
}
