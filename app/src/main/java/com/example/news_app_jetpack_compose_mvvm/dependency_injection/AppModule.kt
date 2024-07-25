package com.example.news_app_jetpack_compose_mvvm.dependency_injection

import android.app.Application
import android.content.Context
import com.example.news_app_jetpack_compose_mvvm.data.manager.LocalUserManagerImp
import com.example.news_app_jetpack_compose_mvvm.data.remote.NewsApi
import com.example.news_app_jetpack_compose_mvvm.data.repository.NewsRepositoryImpl
import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import com.example.news_app_jetpack_compose_mvvm.domain.newsRepository.NewsRepository
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.AppEntryUseCases
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.ReadAppEntry
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.app_entry.SaveAppEntry
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.GetNews
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.NewsUseCases
import com.example.news_app_jetpack_compose_mvvm.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi():NewsApi{
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

}