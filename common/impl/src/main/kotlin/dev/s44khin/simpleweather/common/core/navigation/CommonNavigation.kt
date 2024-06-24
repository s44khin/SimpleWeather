package dev.s44khin.simpleweather.common.core.navigation

import androidx.navigation.NavGraphBuilder
import dev.s44khin.simpleweather.common.api.navigation.CommonNavigation
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogScreen
import dev.s44khin.simpleweather.navigation.api.bottomSheet

fun NavGraphBuilder.commonNavigation() {
    bottomSheet(destination = CommonNavigation.ConfirmationDialog) {
        ConfirmationDialogScreen()
    }
}
