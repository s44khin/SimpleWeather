package dev.s44khin.simpleweather.core.base

import kotlinx.coroutines.flow.MutableStateFlow

class StateStoreImpl<STATE : Any>(
    initState: STATE,
) : StateStore<STATE> {

    override val uiStateFlow = MutableStateFlow(initState)
    override var uiState: STATE
        get() = uiStateFlow.value
        set(value) {
            uiStateFlow.value = value
        }
}