package dev.s44khin.simpleweather.common.data.local

import android.content.Context
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.utils.enumValueOrDefault
import dev.s44khin.simpleweather.utils.getEnum
import dev.s44khin.simpleweather.utils.putEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class SharedPrefSettings(
    private val context: Context,
) {

    private companion object {
        const val SETTINGS = "settings"
        const val UNITS = "units"
        const val COLOR = "color"
        const val THEME = "theme"
        const val TRANSPARENT = "transparent"
        const val ALWAYS_SHOW_LABEL = "always_show_label"
    }

    private val sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)

    private val _unitsFlow = MutableStateFlow(
        value = sharedPreferences.getEnum(key = UNITS, default = Units.Default)
    )

    val unitsFlow = _unitsFlow.asStateFlow()

    private val _colorFlow = MutableStateFlow(
        value = enumValueOrDefault(
            string = sharedPreferences.getString(
                COLOR, PrimaryColor.CedarChest.name
            ) ?: PrimaryColor.CedarChest.name,
            default = PrimaryColor.CedarChest
        )
    )

    val colorFlow = _colorFlow.asStateFlow()

    private val _themeFlow = MutableStateFlow(
        value = sharedPreferences.getEnum(
            key = THEME,
            default = Theme.System,
        ),
    )

    val themeFlow = _themeFlow.asStateFlow()

    private val _transparentFlow = MutableStateFlow(
        value = sharedPreferences.getBoolean(TRANSPARENT, true)
    )

    val transparentFlow = _transparentFlow.asStateFlow()

    private val _alwaysShowLabelFlow = MutableStateFlow(
        value = sharedPreferences.getBoolean(ALWAYS_SHOW_LABEL, true)
    )

    val alwaysShowLabelFlow = _alwaysShowLabelFlow.asStateFlow()

    suspend fun setUnits(units: Units) {
        sharedPreferences.putEnum(
            key = UNITS,
            value = units,
        )

        _unitsFlow.emit(units)
    }

    suspend fun setColor(color: PrimaryColor) {
        sharedPreferences
            .edit()
            .putString(COLOR, color.name)
            .apply()

        _colorFlow.emit(color)
    }

    suspend fun setTheme(theme: Theme) {
        sharedPreferences.putEnum(
            key = THEME,
            value = theme,
        )

        _themeFlow.emit(theme)
    }

    suspend fun setTransparent(transparent: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(TRANSPARENT, transparent)
            .apply()

        _transparentFlow.emit(transparent)
    }

    suspend fun setAlwaysShowLabel(alwaysShowLabel: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(ALWAYS_SHOW_LABEL, alwaysShowLabel)
            .apply()

        _alwaysShowLabelFlow.emit(alwaysShowLabel)
    }
}