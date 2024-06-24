package dev.s44khin.simpleweather.common.presentation.searchDialog

sealed class SearchDialogAction {

    data object OnCloseClicked : SearchDialogAction()
    data class OnSearchInput(val query: String) : SearchDialogAction()
}