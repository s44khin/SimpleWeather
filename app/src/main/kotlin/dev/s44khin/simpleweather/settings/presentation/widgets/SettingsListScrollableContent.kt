package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.settings.presentation.SettingsListAction
import dev.s44khin.simpleweather.settings.presentation.SettingsListUiState
import dev.s44khin.simpleweather.uikit.util.Spacer

@Composable
fun ColumnScope.SettingsListScrollableContent(
    state: SettingsListUiState,
    onAction: (SettingsListAction) -> Unit,
) {
    Spacer(height = 32.dp)

    UnitsBlock(
        selectedUnit = state.tempUnits,
        onUnitClicked = { onAction(SettingsListAction.OnUnitsClicked(it)) }
    )
}