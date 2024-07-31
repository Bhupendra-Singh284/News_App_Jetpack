package com.example.news_app_jetpack_compose_mvvm.presentation.bookmark

import com.example.news_app_jetpack_compose_mvvm.domain.model.Article

data class BookmarkState(var article: List<Article> = listOf())