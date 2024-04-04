package dev.s44khin.simpleweather.uikit.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.Spacer(height: Dp) = Spacer(modifier = Modifier.height(height))

@Composable
fun RowScope.Spacer(width: Dp) = Spacer(modifier = Modifier.width(width))