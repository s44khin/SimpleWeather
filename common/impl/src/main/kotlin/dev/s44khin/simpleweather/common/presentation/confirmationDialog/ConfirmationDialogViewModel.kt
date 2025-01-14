package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import dev.s44khin.simpleweather.common.api.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.utils.AutoClearable

internal class ConfirmationDialogViewModel(
    private val screenRouter: ScreenRouter,
    confirmationDialogDataInMemory: AutoClearable<ConfirmationDialogData>,
) : BaseViewModel<ConfirmationDialogScreenState, ConfirmationDialogUiState, ConfirmationDialogAction>(
    initState = confirmationDialogDataInMemory.value.let { data ->
        ConfirmationDialogScreenState(
            title = data?.title,
            text = data?.text,
            icon = data?.icon,
            confirmButtonData = data?.confirmButtonData,
            cancelButtonLabel = data?.cancelButtonLabel,
        )
    },
    converter = ConfirmationDialogConverter::convert
) {

    override fun onAction(action: ConfirmationDialogAction) = when (action) {
        is ConfirmationDialogAction.OnConfirmButtonClicked -> onConfirmButtonClicked()
        is ConfirmationDialogAction.OnCancelButtonClicked -> onCancelButtonClicked()
    }

    private fun onConfirmButtonClicked() {
        screenRouter.navigateBack(
            signal = screenState.confirmButtonData?.onClickSignal
        )
    }

    private fun onCancelButtonClicked() {
        screenRouter.navigateBack()
    }
}