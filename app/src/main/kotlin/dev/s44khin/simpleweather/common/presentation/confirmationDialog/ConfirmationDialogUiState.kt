package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.utils.NativeText

@Immutable
data class ConfirmationDialogUiState(
    val title: NativeText? = null,
    val text: NativeText? = null,
    val icon: ImageVector? = null,
    val confirmButtonData: ConfirmationDialogButtonDataVo? = null,
    val cancelButtonLabel: NativeText? = null,
)

data class ConfirmationDialogButtonDataVo(
    val label: NativeText,
)
