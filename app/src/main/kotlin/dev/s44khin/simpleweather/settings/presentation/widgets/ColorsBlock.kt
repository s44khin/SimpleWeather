package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.InfoBlock

@Composable
fun ColumnScope.ColorsBlock(
    primaryColor: PrimaryColorVo,
    onColorClicked: (PrimaryColorVo) -> Unit,
) {
    InfoBlock(
        label = stringResource(R.string.settings_colors),
        info = stringResource(R.string.settings_colors_info),
        content = {
            Row(
                modifier = Modifier
                    .horizontalScroll(state = rememberScrollState())
                    .padding(vertical = 8.dp)
            ) {
                Spacer(width = 8.dp)

                ColorFirstColumn()

                Spacer(width = 8.dp)

                PrimaryColorVo.entries.fastForEach {
                    PrimaryColorItem(
                        primaryColorVo = it,
                        selected = it == primaryColor,
                        onClick = { onColorClicked(it) }
                    )

                    Spacer(width = 8.dp)
                }
            }
        }
    )
}