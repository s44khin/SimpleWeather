package dev.s44khin.simpleweather.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

abstract class BaseViewModel<SCREEN_STATE : Any, UI_STATE : Any, ACTION>(
    initState: SCREEN_STATE,
    converter: (SCREEN_STATE) -> UI_STATE,
) : ViewModel(), ActionHandler<ACTION>, StateStore<SCREEN_STATE, UI_STATE> {

    final override val screenStateFlow = MutableStateFlow(initState)
    final override var screenState: SCREEN_STATE
        get() = screenStateFlow.value
        @Synchronized
        set(value) {
            screenStateFlow.value = value
        }

    final override val uiStateFlow = screenStateFlow
        .map { converter(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = converter(screenStateFlow.value)
        )
}
