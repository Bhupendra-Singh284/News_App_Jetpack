package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveAppEntry: SaveAppEntry
) :ViewModel() {
    fun onEvent(event:OnBoardingEvent){
        when(event)
        {
            is OnBoardingEvent.OnGetStartedEvent -> saveUserEntry()
        }
    }

    private fun saveUserEntry(){
        viewModelScope.launch{
            saveAppEntry()
        }
    }

}