package com.example.news_app_jetpack_compose_mvvm.domain.model

import android.os.Parcelable
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    var author: String?="",
    var content: String?="",
    var description: String?="",
    var publishedAt: String?="",
    var source: Source?,
    var title: String?="",
    @PrimaryKey val url: String="",
    var urlToImage: String?=""
):Parcelable