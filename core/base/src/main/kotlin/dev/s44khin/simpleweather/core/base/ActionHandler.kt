package dev.s44khin.simpleweather.core.base

interface ActionHandler<ACTION> {

    fun onAction(action: ACTION)
}