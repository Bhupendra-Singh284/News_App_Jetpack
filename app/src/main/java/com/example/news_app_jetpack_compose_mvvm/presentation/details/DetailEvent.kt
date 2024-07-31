package com.example.news_app_jetpack_compose_mvvm.presentation.details

import com.example.news_app_jetpack_compose_mvvm.domain.model.Article

sealed class DetailEvent {
    data class Bookmark(val article: Article) : DetailEvent()
}