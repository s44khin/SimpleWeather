package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.common.api.domain.model.ConfirmationDialogButtonData
import dev.s44khin.simpleweather.utils.NativeText

internal data class ConfirmationDialogScreenState(
    val title: NativeText? = null,
    val text: NativeText? = null,
    val icon: ImageVector? = null,
    val confirmButtonData: ConfirmationDialogButtonData? = null,
    val cancelButtonLabel: NativeText? = null,
)
