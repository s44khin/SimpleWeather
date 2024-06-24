package dev.s44khin.simpleweather.common.presentation.searchDialog

import androidx.lifecycle.viewModelScope
import dev.s44khin.simpleweather.common.api.domain.useCases.SearchLocationUseCase
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import dev.s44khin.simpleweather.utils.CancellableJob
import dev.s44khin.simpleweather.utils.launchUiCoroutine

internal class SearchDialogViewModel(
    private val converter: SearchDialogConverter,
    private val screenRouter: ScreenRouter,
    private val searchLocationUseCase: SearchLocationUseCase,
) : BaseViewModel<SearchDialogScreenState, SearchDialogUiState, SearchDialogAction>(
    initState = SearchDialogScreenState(),
    converter = converter::convert
) {

    private val searchJob = CancellableJob {
        searchLocation()
    }

    override fun onAction(action: SearchDialogAction) = when (action) {
        is SearchDialogAction.OnCloseClicked -> screenRouter.navigateBack()
        is SearchDialogAction.OnSearchInput -> onSearchInput(action.query)
    }

    private fun onSearchInput(query: String) {
        screenState = screenState.copy(
            query = query,
        )

        searchJob.launch()
    }

    private fun searchLocation() {
        viewModelScope.launchUiCoroutine(
            onError = { }
        ) {
            screenState = screenState.copy(
                result = searchLocationUseCase.execute(
                    name = screenState.query
                ),
            )
        }
    }
}