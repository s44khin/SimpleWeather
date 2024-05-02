package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo
import dev.s44khin.simpleweather.settings.presentation.SettingsListAction
import dev.s44khin.simpleweather.settings.presentation.SettingsListUiState
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple
import dev.s44khin.simpleweather.uikit.widgets.InfoBlock

@Composable
fun ColumnScope.ThemeBlock(
    state: SettingsListUiState,
    onAction: (SettingsListAction) -> Unit,
) {
    InfoBlock(
        label = stringResource(R.string.settings_theme),
        content = {
            Row(modifier = Modifier.padding(vertical = 24.dp, horizontal = 8.dp)) {
                ThemeVo.entries.fastForEach {
                    ThemeItem(
                        modifier = Modifier
                            .weight(1f)
                            .clickableWithoutRipple {
                                onAction(SettingsListAction.OnThemeClicked(it))
                            },
                        selected = state.theme == it,
                        theme = it,
                    )
                }
            }
        }
    )
}