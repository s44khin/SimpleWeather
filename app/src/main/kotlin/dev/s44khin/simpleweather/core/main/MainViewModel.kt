package dev.s44khin.simpleweather.core.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    fun onAction(action: MainAction) = when (action) {
        is MainAction.OnBottomNavigationClicked ->  {}
    }
}
