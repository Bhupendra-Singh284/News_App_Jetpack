package com.example.news_app_jetpack_compose_mvvm.domain.newsRepository

import androidx.paging.PagingData
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>): Flow<PagingData<Article>>
}