package dev.s44khin.simpleweather.common.presentation.searchDialog

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import javax.inject.Inject

@HiltViewModel
class SearchDialogViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
    private val converter: SearchDialogConverter,
) : BaseViewModel<SearchDialogScreenState, SearchDialogUiState, SearchDialogAction>(
    initState = SearchDialogScreenState,
    converter = converter::convert
) {

    override fun onAction(action: SearchDialogAction) = when (action) {
        is SearchDialogAction.OnCloseClicked -> screenRouter.navigateBack()
    }
}