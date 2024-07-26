package com.example.news_app_jetpack_compose_mvvm.presentation.details

sealed class DetailEvent {
    data object bookmark:DetailEvent()
}