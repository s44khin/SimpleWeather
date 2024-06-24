package dev.s44khin.simpleweather.common.presentation.confirmationDialog

internal class ConfirmationDialogConverter {

    fun convert(screenState: ConfirmationDialogScreenState) = ConfirmationDialogUiState(
        title = screenState.title,
        text = screenState.text,
        icon = screenState.icon,
        confirmButtonData = screenState.confirmButtonData?.let {
            ConfirmationDialogButtonDataVo(
                label = it.label
            )
        },
        cancelButtonLabel = screenState.cancelButtonLabel
    )
}
