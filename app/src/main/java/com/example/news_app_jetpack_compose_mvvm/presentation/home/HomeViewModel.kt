package com.example.news_app_jetpack_compose_mvvm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNews: GetNews
) :ViewModel() {
    val news = getNews(sources = listOf("bbc-news","abc-news","al-jazeera-english","wired","business-insider","techcrunch","the-verge"))
        .cachedIn(viewModelScope)
}

