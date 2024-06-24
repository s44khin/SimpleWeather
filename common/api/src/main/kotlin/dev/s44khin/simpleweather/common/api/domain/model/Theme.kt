package dev.s44khin.simpleweather.common.api.domain.model

enum class Theme {
    System, Dark, Light;

    val isDefault get() = this == System

    val isNotDefault get() = isDefault.not()

    companion object {
        val Default = System
    }
}
