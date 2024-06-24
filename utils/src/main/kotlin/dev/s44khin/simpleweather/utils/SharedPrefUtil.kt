package dev.s44khin.simpleweather.utils

import android.content.SharedPreferences

fun <E : Enum<E>> SharedPreferences.putEnum(key: String, value: E) {
    edit()
        .putString(key, value.name)
        .apply()
}

inline fun <reified E : Enum<E>> SharedPreferences.getEnum(key: String, default: E) = enumValueOrDefault(
    string = getString(key, default.name) ?: "",
    default = default,
)
