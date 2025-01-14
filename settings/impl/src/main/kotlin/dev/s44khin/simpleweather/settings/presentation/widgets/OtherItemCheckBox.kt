package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun OtherItemCheckBox(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(48.dp)
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            text = label,
            color = SimpleTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
        )

        Checkbox(
            checked = selected,
            onCheckedChange = { onClicked() },
            colors = CheckboxDefaults.colors(
                checkedColor = SimpleTheme.colors.primary,
                checkmarkColor = SimpleTheme.colors.onPrimary
            )
        )
    }
}