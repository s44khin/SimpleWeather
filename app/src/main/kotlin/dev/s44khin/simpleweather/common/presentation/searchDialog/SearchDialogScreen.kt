package dev.s44khin.simpleweather.common.presentation.searchDialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.widgets.SearchItem
import dev.s44khin.simpleweather.common.presentation.searchDialog.widgets.SearchTopNavigation
import dev.s44khin.simpleweather.common.presentation.searchDialog.widgets.SearchTopNavigationHeight
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.DialogLayoutBox

@Composable
fun SearchDialogScreen() = DialogLayoutBox {
    val viewModel = hiltViewModel<SearchDialogViewModel>()
    val state by viewModel.uiStateFlow.collectAsState()
    val scrollState = rememberScrollState()

    SearchTopNavigation(
        query = state.query,
        scrollState = scrollState,
        onSearchInput = { viewModel.onAction(SearchDialogAction.OnSearchInput(it)) },
        onCloseClicked = { viewModel.onAction(SearchDialogAction.OnCloseClicked) }
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .imePadding()
            .verticalScroll(state = scrollState)
    ) {
        Spacer(height = SearchTopNavigationHeight + 8.dp)

        state.result.fastForEachIndexed { index, item ->
            SearchItem(
                item = item,
                shape = getShape(
                    lastIndex = state.result.lastIndex,
                    index = index
                ),
                onClick = {}
            )

            Spacer(height = 4.dp)
        }
    }
}

@Stable
private fun getShape(lastIndex: Int, index: Int) = RoundedCornerShape(
    topStart = if (index == 0) 16.dp else 2.dp,
    topEnd = if (index == 0) 16.dp else 2.dp,
    bottomStart = if (lastIndex == index) 16.dp else 2.dp,
    bottomEnd = if (lastIndex == index) 16.dp else 2.dp,
)
