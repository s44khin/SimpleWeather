package dev.s44khin.simpleweather.core.base

import kotlinx.coroutines.flow.StateFlow

interface StateStore<STATE : Any> {

    val uiStateFlow: StateFlow<STATE>
    var uiState: STATE
}