package dev.s44khin.simpleweather.common.presentation.confirmationDialog

sealed class ConfirmationDialogAction {

    data object OnConfirmButtonClicked :
        ConfirmationDialogAction()

    data object OnCancelButtonClicked :
        ConfirmationDialogAction()
}