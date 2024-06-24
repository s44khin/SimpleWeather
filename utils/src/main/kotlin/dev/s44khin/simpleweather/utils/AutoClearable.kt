package dev.s44khin.simpleweather.utils

abstract class AutoClearable<T> {

    var value: T? = null
        get() = field.also { field = null }

    fun clear() {
        value = null
    }
}