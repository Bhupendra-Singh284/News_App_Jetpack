package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news

import com.example.news_app_jetpack_compose_mvvm.data.local.NewsDao
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import javax.inject.Inject

class GetSpecifiedArticle @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(articleURL:String): Article?{
        return newsDao.getSpecifiedArticle(articleURL=articleURL)
    }
}