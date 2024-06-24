package dev.s44khin.simpleweather.core.base

import kotlinx.coroutines.flow.StateFlow

interface StateStore<SCREEN_STATE : Any, UI_STATE : Any> {

    val screenStateFlow: StateFlow<SCREEN_STATE>

    var screenState: SCREEN_STATE

    val uiStateFlow: StateFlow<UI_STATE>
}