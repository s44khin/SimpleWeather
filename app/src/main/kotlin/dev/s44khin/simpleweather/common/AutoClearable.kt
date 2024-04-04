package dev.s44khin.simpleweather.common

abstract class AutoClearable<T> {

    var value: T? = null
        get() = field.also { field = null }

    fun clear() {
        value = null
    }
}