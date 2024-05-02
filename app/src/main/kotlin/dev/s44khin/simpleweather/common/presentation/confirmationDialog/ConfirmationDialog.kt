package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ColumnScope.ConfirmationDialog() {
    val viewModel = hiltViewModel<ConfirmationDialogViewModel>()
    val state by viewModel.uiStateFlow.collectAsState()

    ConfirmationDialogContent(
        state = state,
        onAction = viewModel::onAction
    )
}