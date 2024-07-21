package com.example.news_app_jetpack_compose_mvvm.presentation.main_activity

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.AppEntryUseCases
import com.example.news_app_jetpack_compose_mvvm.presentation.navigation.Route
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
):ViewModel() {
    var _splashCondition = mutableStateOf(true)
        private set

    var _startDestination = mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().collect{value->
                if(value){
                    _startDestination.value= Route.NewsNavigation.route
                }
                delay(600)
                _splashCondition.value=false
            }
        }
    }
}