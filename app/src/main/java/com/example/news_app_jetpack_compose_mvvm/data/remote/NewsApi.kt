package com.example.news_app_jetpack_compose_mvvm.data.remote

import com.example.news_app_jetpack_compose_mvvm.data.remote.dto.NewsResponse
import com.example.news_app_jetpack_compose_mvvm.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey:String = Constants.API_KEY,
        @Query("page") page:Int,
        @Query("sources") sources:String
    ):NewsResponse


    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery:String,
        @Query("apiKey") apiKey:String = Constants.API_KEY,
        @Query("page") page:Int,
        @Query("sources") sources:String
    ):NewsResponse
}