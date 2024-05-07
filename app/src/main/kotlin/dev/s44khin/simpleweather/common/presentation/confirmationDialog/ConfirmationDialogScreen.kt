package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.uikit.widgets.DialogLayoutColumn

@Composable
fun ConfirmationDialogScreen() {
    val viewModel = hiltViewModel<ConfirmationDialogViewModel>()
    val state by viewModel.uiStateFlow.collectAsState()

    DialogLayoutColumn {
        ConfirmationDialogContent(
            state = state,
            onAction = viewModel::onAction
        )
    }
}