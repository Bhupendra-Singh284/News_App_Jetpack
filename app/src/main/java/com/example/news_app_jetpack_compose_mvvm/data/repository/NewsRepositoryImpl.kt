package com.example.news_app_jetpack_compose_mvvm.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.news_app_jetpack_compose_mvvm.data.remote.NewsApi
import com.example.news_app_jetpack_compose_mvvm.data.remote.NewsPagingSource
import com.example.news_app_jetpack_compose_mvvm.data.remote.SearchPagingSource
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.domain.newsRepository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
):NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi,sources.joinToString(","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchPagingSource(searchQuery=searchQuery,newsApi,sources.joinToString(","))
            }
        ).flow
    }
}