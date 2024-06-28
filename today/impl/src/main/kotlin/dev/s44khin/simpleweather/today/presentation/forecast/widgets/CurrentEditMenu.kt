package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun RowScope.CurrentEditMenu(
    location: String,
    time: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(14.dp)
                .alignByBaseline(),
            imageVector = Icons.Outlined.LocationOn,
            contentDescription = null,
            tint = SimpleTheme.colors.onBackgroundUnselected,
        )

        Text(
            modifier = Modifier.alignByBaseline(),
            text = location,
            style = MaterialTheme.typography.bodySmall,
            color = SimpleTheme.colors.onBackgroundUnselected
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(14.dp)
                .alignByBaseline(),
            imageVector = Icons.Outlined.Refresh,
            contentDescription = null,
            tint = SimpleTheme.colors.onBackgroundUnselected,
        )

        Text(

            modifier = Modifier.alignByBaseline(),
            text = time,
            style = MaterialTheme.typography.bodySmall,
            color = SimpleTheme.colors.onBackgroundUnselected
        )
    }
}
