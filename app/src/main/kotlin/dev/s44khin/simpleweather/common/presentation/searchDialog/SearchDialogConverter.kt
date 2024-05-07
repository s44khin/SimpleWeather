package dev.s44khin.simpleweather.common.presentation.searchDialog

import javax.inject.Inject

class SearchDialogConverter @Inject constructor() {

    fun convert(screenState: SearchDialogScreenState) = SearchDialogUiState
}