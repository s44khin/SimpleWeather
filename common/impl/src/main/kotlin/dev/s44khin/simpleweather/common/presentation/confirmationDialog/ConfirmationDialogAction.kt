package dev.s44khin.simpleweather.common.presentation.confirmationDialog

internal sealed class ConfirmationDialogAction {

    data object OnConfirmButtonClicked : ConfirmationDialogAction()
    data object OnCancelButtonClicked : ConfirmationDialogAction()
}