package dev.s44khin.simpleweather.utils

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.launchUiCoroutine(
    onError: (throwable: Throwable) -> Unit,
    block: suspend CoroutineScope.() -> Unit,
) {
    launch(
        context = CoroutineExceptionHandler { _, throwable ->
            Log.e("CoroutineExceptionHandler", throwable.message.toString())
            onError(throwable)
        },
        block = block,
    )
}