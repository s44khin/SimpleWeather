package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.utils.NativeText

data class ConfirmationDialogScreenState(
    val title: NativeText? = null,
    val text: NativeText? = null,
    val icon: ImageVector? = null,
    val confirmButtonData: dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogButtonData? = null,
    val cancelButtonLabel: NativeText? = null,
)
