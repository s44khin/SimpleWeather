package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.settings.presentation.SettingsListAction
import dev.s44khin.simpleweather.settings.presentation.SettingsListUiState
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
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

    Spacer(height = 48.dp)

    ColorsBlock(
        primaryColor = state.primaryColor,
        onColorClicked = { onAction(SettingsListAction.OnColorClicked(it)) }
    )

    Spacer(height = 48.dp)

    ThemeBlock()

    Spacer(height = 48.dp)

    OtherBlock(
        state = state,
        onAction = onAction,
    )

    Spacer(height = 48.dp)

    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = "s44khin",
        color = SimpleTheme.colors.onBackgroundUnselected,
        fontSize = 12.sp,
    )
}