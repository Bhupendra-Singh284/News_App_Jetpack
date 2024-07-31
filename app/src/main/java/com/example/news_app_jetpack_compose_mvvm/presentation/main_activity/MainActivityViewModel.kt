package com.example.news_app_jetpack_compose_mvvm.presentation.main_activity

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.ReadAppEntry
import com.example.news_app_jetpack_compose_mvvm.presentation.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
):ViewModel() {
    var _splashCondition = mutableStateOf(true)
        private set

    var _startDestination = mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        viewModelScope.launch {
            readAppEntry().collect{value->
                if(value){
                    _startDestination.value= Route.NewsNavigation.route
                }
                delay(600)
                _splashCondition.value=false
            }
        }
    }
}