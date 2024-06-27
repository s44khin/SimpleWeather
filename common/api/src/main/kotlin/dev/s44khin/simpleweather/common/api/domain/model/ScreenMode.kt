package dev.s44khin.simpleweather.common.api.domain.model

enum class ScreenMode {
    Loading, Content, Error;

    val isContent get() = this == Content

    val isLoading get() = this == Loading

    val isError get() = this == Error

    val isNotContent get() = this != Content

    val isNotLoading get() = this != Loading

    val isNotError get() = this != Error
}
