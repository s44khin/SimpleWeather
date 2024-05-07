package dev.s44khin.simpleweather.common.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogScreen
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogScreen
import dev.s44khin.simpleweather.core.navigation.NavDestination
import dev.s44khin.simpleweather.core.navigation.bottomSheet

object CommonNavigation : NavDestination {

    override val route = "common"

    object ConfirmationDialog : NavDestination {

        override val route = "${CommonNavigation.route}/confirmation_dialog"
    }

    object SearchDialog : NavDestination {

        override val route = "${ConfirmationDialog.route}/search_dialog"
    }
}

fun NavGraphBuilder.commonNavigation() {
    bottomSheet(destination = CommonNavigation.ConfirmationDialog) {
        ConfirmationDialogScreen()
    }

    bottomSheet(destination = CommonNavigation.SearchDialog) {
        SearchDialogScreen()
    }
}
