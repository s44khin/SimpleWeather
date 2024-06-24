package dev.s44khin.simpleweather.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun ViewModel.CancellableJob(
    delay: Long = 1500,
    onDelayEnd: () -> Unit,
) = CancellableJob(
    scope = viewModelScope,
    delay = delay,
    onDelayEnd = onDelayEnd,
)

class CancellableJob(
    val scope: CoroutineScope,
    val delay: Long = 1500,
    val onDelayEnd: () -> Unit,
) {

    private var job: Job? = null

    fun launch() {
        job?.cancel()

        job = scope.launch {
            delay(delay)
            onDelayEnd()
        }
    }
}