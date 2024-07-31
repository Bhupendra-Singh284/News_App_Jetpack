package com.example.news_app_jetpack_compose_mvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase:RoomDatabase(){
    abstract fun getDao():NewsDao
}