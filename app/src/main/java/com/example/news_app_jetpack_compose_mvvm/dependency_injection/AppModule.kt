package com.example.news_app_jetpack_compose_mvvm.dependency_injection

import android.app.Application
import android.content.Context
import com.example.news_app_jetpack_compose_mvvm.data.manager.LocalUserManagerImp
import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.AppEntryUseCases
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.ReadAppEntry
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(context = application)

    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )
    }
}