package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase
import javax.inject.Inject

@HiltViewModel
class TodayForecastViewModel @Inject constructor(
    private val getTodayWeatherUseCase: GetTodayWeatherUseCase,
) : ViewModel() {

    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            getTodayWeatherUseCase.execute()
//        }
    }
}
