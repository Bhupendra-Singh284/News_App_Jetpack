package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news

import androidx.paging.PagingData
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.domain.newsRepository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(query:String,sources:List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(query,sources)
    }
}