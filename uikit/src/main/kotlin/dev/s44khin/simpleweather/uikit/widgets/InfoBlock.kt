package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer

@Composable
fun ColumnScope.InfoBlock(
    label: String? = null,
    info: String? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    if (label != null) {
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = label.uppercase(),
            color = SimpleTheme.colors.onBackgroundUnselected,
            fontSize = 12.sp,
        )

        Spacer(height = 6.dp)
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(
                color = SimpleTheme.colors.background,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp)),
        content = content,
    )

    if (info != null) {
        Spacer(height = 6.dp)

        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = info,
            color = SimpleTheme.colors.onBackgroundUnselected,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        )
    }
}