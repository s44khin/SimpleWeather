package dev.s44khin.simpleweather.common.presentation.searchDialog

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.common.domain.useCases.SearchLocationUseCase
import dev.s44khin.simpleweather.common.util.CancellableJob
import dev.s44khin.simpleweather.common.util.launchUiCoroutine
import dev.s44khin.simpleweather.core.base.BaseViewModel
import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import javax.inject.Inject

@HiltViewModel
class SearchDialogViewModel @Inject constructor(
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