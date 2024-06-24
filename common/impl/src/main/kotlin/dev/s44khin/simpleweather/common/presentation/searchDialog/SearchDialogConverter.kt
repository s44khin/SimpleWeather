package dev.s44khin.simpleweather.common.presentation.searchDialog

import dev.s44khin.simpleweather.common.presentation.model.SearchLocationLocalNamesVo
import dev.s44khin.simpleweather.common.presentation.model.SearchLocationVo

internal object SearchDialogConverter {

    fun convert(screenState: SearchDialogScreenState) = SearchDialogUiState(
        query = screenState.query,
        result = screenState.result.map {
            SearchLocationVo(
                name = it.name,
                lat = it.lat,
                lon = it.lon,
                country = it.country,
                state = it.state,
                localNames = SearchLocationLocalNamesVo(
                    ru = it.localNames.ru,
                    en = it.localNames.en
                )
            )
        }
    )
}