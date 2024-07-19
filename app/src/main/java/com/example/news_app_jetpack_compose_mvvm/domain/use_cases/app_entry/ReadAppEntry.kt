package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry

import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke(): Flow<Boolean> {
       return localUserManager.readAppEntry()
    }
}