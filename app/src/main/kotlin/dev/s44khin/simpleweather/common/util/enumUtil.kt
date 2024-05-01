package dev.s44khin.simpleweather.common.util

inline fun <reified E : Enum<E>> enumValueOrNull(string: String) = enumValues<E>().firstOrNull {
    it.name.lowercase() == string.lowercase()
}

inline fun <reified E : Enum<E>> enumValueOrDefault(
    string: String,
    default: E
) = enumValueOrNull<E>(string) ?: default