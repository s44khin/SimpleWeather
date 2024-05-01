package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.settings.presentation.model.TempUnitsVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple

@Composable
fun ColumnScope.UnitsBlock(
    selectedUnit: TempUnitsVo,
    onUnitClicked: (TempUnitsVo) -> Unit,
) {
    Text(
        modifier = Modifier.padding(horizontal = 32.dp),
        text = stringResource(R.string.settings_units).uppercase(),
        color = SimpleTheme.colors.onBackgroundUnselected,
        fontSize = 14.sp,
    )

    Spacer(height = 8.dp)

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(
                color = SimpleTheme.colors.background,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 24.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TempUnitsVo.entries.fastForEach {
            UnitItem(
                modifier = Modifier
                    .weight(1f)
                    .clickableWithoutRipple { onUnitClicked(it) },
                label = it.label.resolve(),
                sample = it.sample.resolve(),
                selected = it == selectedUnit,
            )
        }
    }
}