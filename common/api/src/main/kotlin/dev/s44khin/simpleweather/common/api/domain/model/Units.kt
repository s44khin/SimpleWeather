package dev.s44khin.simpleweather.common.api.domain.model

enum class Units {
    Default, Metric, Imperial;

    val isDefault get() = this == Default

    val isNotDefault get() = isDefault.not()

    companion object;
}

