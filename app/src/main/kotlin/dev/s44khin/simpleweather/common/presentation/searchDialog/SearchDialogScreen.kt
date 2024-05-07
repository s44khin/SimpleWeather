package dev.s44khin.simpleweather.common.presentation.searchDialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.widgets.SearchTopNavigation
import dev.s44khin.simpleweather.common.presentation.searchDialog.widgets.SearchTopNavigationHeight
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.DialogLayoutBox

@Composable
fun SearchDialogScreen() = DialogLayoutBox {
    val viewModel = hiltViewModel<SearchDialogViewModel>()
    val scrollState = rememberScrollState()

    SearchTopNavigation(
        scrollState = scrollState,
        onCloseClicked = { viewModel.onAction(SearchDialogAction.OnCloseClicked) }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(state = scrollState)
    ) {
        Spacer(height = SearchTopNavigationHeight + 32.dp)

        repeat(100) {
            Text(text = "Test")
            Spacer(height = 16.dp)
        }
    }
}