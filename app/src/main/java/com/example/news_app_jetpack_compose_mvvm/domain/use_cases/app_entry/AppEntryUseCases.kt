package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry

import javax.inject.Inject
import javax.inject.Singleton

data class AppEntryUseCases (
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
