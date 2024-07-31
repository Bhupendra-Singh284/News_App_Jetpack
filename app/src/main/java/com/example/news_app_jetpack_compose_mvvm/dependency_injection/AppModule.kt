package com.example.news_app_jetpack_compose_mvvm.dependency_injection

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabase.Builder
import com.example.news_app_jetpack_compose_mvvm.data.local.NewsDao
import com.example.news_app_jetpack_compose_mvvm.data.local.NewsDatabase
import com.example.news_app_jetpack_compose_mvvm.data.local.NewsTypeConverter
import com.example.news_app_jetpack_compose_mvvm.data.remote.NewsApi
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

    @Provides
    @Singleton
    fun provideNewsDatabase(
        context:Application
    ):NewsDatabase{
        return Room.databaseBuilder(
            context=context,
            name=Constants.DATABASE_NAME,
            klass = NewsDatabase::class.java
        ).addTypeConverter(NewsTypeConverter()).build()
    }

    @Provides
    @Singleton
    fun getNewsDao(
        newsDatabase: NewsDatabase
    ):NewsDao{
        return  newsDatabase.getDao()
    }

}