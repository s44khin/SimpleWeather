package dev.s44khin.simpleweather.common.api.presentation.model

import dev.s44khin.simpleweather.common.api.domain.model.ScreenMode
import dev.s44khin.simpleweather.utils.enumValueOrDefault

enum class ScreenModeVo {
    Loading, Content, Error;

    val isContent get() = this == Content

    val isLoading get() = this == Loading

    val isError get() = this == Error

    val isNotContent get() = this != Content

    val isNotLoading get() = this != Loading

    val isNotError get() = this != Error
}

fun ScreenMode.toScreenModeVo() = enumValueOrDefault(
    string = name,
    default = ScreenModeVo.Content,
)