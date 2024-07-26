package com.example.news_app_jetpack_compose_mvvm.presentation.details

import androidx.lifecycle.ViewModel
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor():ViewModel() {
    fun onEvent(detailEvent: DetailEvent){
        when(detailEvent)
        {
            is DetailEvent.bookmark->{}
        }
    }
}