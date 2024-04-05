package dev.s44khin.simpleweather.uikit.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class NativeText {

    companion object {
        val Empty = Simple(string = "")
    }

    data class Resource(@StringRes val resId: Int) : NativeText()

    data class Simple(val string: String) : NativeText()

    @Composable
    fun resolve() = when (this) {
        is Resource -> stringResource(resId)
        is Simple -> string
    }

    fun resolve(context: Context) = when (this) {
        is Resource -> context.getString(resId)
        is Simple -> string
    }
}