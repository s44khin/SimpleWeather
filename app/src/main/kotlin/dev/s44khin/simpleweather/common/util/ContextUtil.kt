package dev.s44khin.simpleweather.common.util

import android.content.Context
import dev.s44khin.simpleweather.core.di.AppComponent
import dev.s44khin.simpleweather.core.main.MainActivity

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainActivity -> appComponent
        else -> error("AppComponent не найден")
    }