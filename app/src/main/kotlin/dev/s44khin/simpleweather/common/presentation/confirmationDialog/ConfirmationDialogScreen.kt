package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.s44khin.simpleweather.uikit.widgets.DialogLayoutColumn
import org.koin.androidx.compose.koinViewModel

@Composable
fun ConfirmationDialogScreen() {
    val viewModel = koinViewModel<ConfirmationDialogViewModel>()
    val state by viewModel.uiStateFlow.collectAsState()

    DialogLayoutColumn {
        ConfirmationDialogContent(
            state = state,
            onAction = viewModel::onAction
        )
    }
}