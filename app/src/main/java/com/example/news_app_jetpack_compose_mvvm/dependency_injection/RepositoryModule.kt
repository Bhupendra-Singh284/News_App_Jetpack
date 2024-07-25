package com.example.news_app_jetpack_compose_mvvm.dependency_injection

import com.example.news_app_jetpack_compose_mvvm.data.repository.NewsRepositoryImpl
import com.example.news_app_jetpack_compose_mvvm.domain.newsRepository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun getRepository(newsRepositoryImpl: NewsRepositoryImpl):NewsRepository
}