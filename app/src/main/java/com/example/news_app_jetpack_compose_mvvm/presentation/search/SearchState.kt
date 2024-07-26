package com.example.news_app_jetpack_compose_mvvm.presentation.search

import androidx.paging.PagingData
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    var query:String="",
    val articles: Flow<PagingData<Article>>?=null
)