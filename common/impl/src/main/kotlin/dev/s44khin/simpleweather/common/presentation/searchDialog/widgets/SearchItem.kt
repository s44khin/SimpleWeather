package dev.s44khin.simpleweather.common.presentation.searchDialog.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.common.presentation.model.SearchLocationVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
fun SearchItem(
    item: SearchLocationVo,
    shape: Shape,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = SimpleTheme.colors.background,
                shape = shape,
            )
            .clip(shape)
            .fillMaxWidth()
            .height(64.dp)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = item.name,
            color = Color.Black
        )

        if (item.state != null) {
            Text(
                text = item.state
            )
        }
    }
}