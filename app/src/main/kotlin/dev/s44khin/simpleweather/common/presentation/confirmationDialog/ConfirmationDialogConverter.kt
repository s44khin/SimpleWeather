package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import javax.inject.Inject

class ConfirmationDialogConverter @Inject constructor() {

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
