package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.clearable.AutoClearable
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import javax.inject.Inject

@HiltViewModel
class ConfirmationDialogViewModel @Inject constructor(
    private val converter: ConfirmationDialogConverter,
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
    converter = converter::convert
) {

    override fun onAction(action: ConfirmationDialogAction) = when (action) {
        is ConfirmationDialogAction.OnConfirmButtonClicked -> onConfirmButtonClicked()
        is ConfirmationDialogAction.OnCancelButtonClicked -> onCancelButtonClicked()
    }

    private fun onConfirmButtonClicked() {

    }

    private fun onCancelButtonClicked() {
        screenRouter.navigateBack()
    }
}