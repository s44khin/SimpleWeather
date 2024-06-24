package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.settings.presentation.SettingsListAction
import dev.s44khin.simpleweather.settings.presentation.SettingsListUiState
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.InfoBlock

@Composable
fun ColumnScope.OtherBlock(
    state: SettingsListUiState,
    onAction: (SettingsListAction) -> Unit,
) {
    InfoBlock(
        label = stringResource(CoreStrings.settings_other),
        content = {
            Column {
                OtherItemCheckBox(
                    label = stringResource(CoreStrings.settings_other_transparent),
                    selected = state.transparent,
                    onClicked = { onAction(SettingsListAction.OnTransparentChanged) }
                )

                HorizontalDivider(
                    color = SimpleTheme.colors.divider
                )

                OtherItemCheckBox(
                    label = stringResource(CoreStrings.settings_other_always_show_label),
                    selected = state.alwaysShowLabel,
                    onClicked = { onAction(SettingsListAction.OnAlwaysShowLabelClicked) }
                )
            }
        }
    )
}
