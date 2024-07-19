package com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry

import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}