package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news

import com.example.news_app_jetpack_compose_mvvm.data.local.NewsDao
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class InsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
         newsDao.insert(article)
    }
}