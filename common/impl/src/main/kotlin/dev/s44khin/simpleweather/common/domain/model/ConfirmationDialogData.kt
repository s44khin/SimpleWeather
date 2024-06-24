package dev.s44khin.simpleweather.common.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.utils.NativeText

data class ConfirmationDialogData(
    val title: NativeText? = null,
    val text: NativeText? = null,
    val icon: ImageVector? = null,
    val confirmButtonData: ConfirmationDialogButtonData? = null,
    val cancelButtonLabel: NativeText? = null,
)

data class ConfirmationDialogButtonData(
    val label: NativeText,
    val onClickSignal: String,
)
