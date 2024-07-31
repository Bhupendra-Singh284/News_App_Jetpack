package com.example.news_app_jetpack_compose_mvvm.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("Select * from Article")
    fun getArticles(): Flow<List<Article>>

    @Query("Select * from Article where url=:articleURL")
    suspend fun getSpecifiedArticle(articleURL:String):Article?
}