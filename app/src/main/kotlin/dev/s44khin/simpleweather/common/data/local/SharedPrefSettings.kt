package dev.s44khin.simpleweather.common.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.util.getEnum
import dev.s44khin.simpleweather.common.util.putEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@ActivityRetainedScoped
class SharedPrefSettings @Inject constructor(
    @ApplicationContext
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
        value = sharedPreferences.getEnum(key = UNITS, default = TempUnits.Kelvin)
    )

    val unitsFlow = _unitsFlow.asStateFlow()

    private val _colorFlow = MutableStateFlow(
        value = PrimaryColor(
            name = sharedPreferences.getString(
                COLOR, PrimaryColorVo.CedarChest.name
            ) ?: PrimaryColorVo.CedarChest.name
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

    suspend fun setUnits(units: TempUnits) {
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