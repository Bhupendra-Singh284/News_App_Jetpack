package com.example.news_app_jetpack_compose_mvvm.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val query:String): SearchEvent()
    data object SearchNews:SearchEvent()
}