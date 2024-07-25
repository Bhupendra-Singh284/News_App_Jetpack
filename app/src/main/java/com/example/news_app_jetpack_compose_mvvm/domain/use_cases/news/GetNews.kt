package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news

import androidx.paging.PagingData
import com.example.news_app_jetpack_compose_mvvm.data.remote.NewsApi
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.domain.newsRepository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources:List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}