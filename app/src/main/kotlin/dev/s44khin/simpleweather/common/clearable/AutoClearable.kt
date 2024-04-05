package dev.s44khin.simpleweather.common.clearable

abstract class AutoClearable<T> {

    var value: T? = null
        get() = field.also { field = null }

    fun clear() {
        value = null
    }
}