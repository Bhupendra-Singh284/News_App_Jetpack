package com.example.news_app_jetpack_compose_mvvm.data.remote.dto

import com.example.news_app_jetpack_compose_mvvm.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)