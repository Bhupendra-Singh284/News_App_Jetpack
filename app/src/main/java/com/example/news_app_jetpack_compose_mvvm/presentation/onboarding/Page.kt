package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.news_app_jetpack_compose_mvvm.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

@Composable
fun getPages(): List<Page> {
    return listOf(
        Page(
            stringResource(id = R.string.onboarding_title1),
            stringResource(id = R.string.onboarding_description1),
            R.drawable.on_boarding_img1
        ),
        Page(
            stringResource(id = R.string.onboarding_title2),
            stringResource(id = R.string.onboarding_description2),
            R.drawable.on_boarding_img2
        ),
        Page(
            stringResource(id = R.string.onboarding_title3),
            stringResource(id = R.string.onboarding_description3),
            R.drawable.on_boarding_img3
        )
    );
}