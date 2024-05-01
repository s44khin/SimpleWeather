package dev.s44khin.simpleweather.core.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<STATE : Any, ACTION>(
    initState: STATE
) : ViewModel(), ActionHandler<ACTION>, StateStore<STATE> by StateStoreImpl(
    initState = initState,
)
