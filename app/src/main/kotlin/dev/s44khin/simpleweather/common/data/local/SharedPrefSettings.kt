package dev.s44khin.simpleweather.common.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
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
    }

    private val sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)

    var units: TempUnits
        get() = sharedPreferences.getEnum(key = UNITS, default = TempUnits.Kelvin)
        set(value) = sharedPreferences.putEnum(key = UNITS, value = value)

    private val _colorFlow = MutableStateFlow(
        value = PrimaryColor(
            name = sharedPreferences.getString(
                COLOR, PrimaryColorVo.CedarChest.name
            ) ?: PrimaryColorVo.CedarChest.name
        )
    )

    val colorFlow = _colorFlow.asStateFlow()

    suspend fun setColor(color: PrimaryColor) {
        sharedPreferences
            .edit()
            .putString(COLOR, color.name)
            .apply()

        _colorFlow.emit(color)
    }
}