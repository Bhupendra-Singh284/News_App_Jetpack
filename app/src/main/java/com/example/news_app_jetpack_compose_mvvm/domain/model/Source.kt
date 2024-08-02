package com.example.news_app_jetpack_compose_mvvm.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.annotation.Nullable

@Parcelize
data class Source(
    var id: String?="",
    var name: String?=""
) :Parcelable