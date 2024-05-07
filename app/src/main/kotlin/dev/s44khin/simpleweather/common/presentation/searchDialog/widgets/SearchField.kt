package dev.s44khin.simpleweather.common.presentation.searchDialog.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

val SearchBarHeight = 36.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchField(
    search: String,
    hint: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = SimpleTheme.colors.background,
    contentColor: Color = SimpleTheme.colors.onBackgroundUnselected,
    onValueChange: (String) -> Unit,
) {
    BasicTextField2(
        modifier = modifier
            .height(36.dp)
            .background(
                color = backgroundColor,
                shape = CircleShape,
            ),
        value = search,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            color = contentColor,
            fontSize = 16.sp
        ),
        decorator = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = contentColor,
                )

                Box(contentAlignment = Alignment.CenterStart) {
                    if (search.isEmpty()) {
                        Text(
                            text = hint,
                            color = Color.Gray,
                            fontSize = 16.sp,
                        )
                    }

                    innerTextField()
                }
            }
        },
    )
}