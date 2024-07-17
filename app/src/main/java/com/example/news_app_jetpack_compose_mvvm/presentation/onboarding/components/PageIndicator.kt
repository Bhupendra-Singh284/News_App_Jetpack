package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.news_app_jetpack_compose_mvvm.presentation.indicatorSize


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(
    modifier: Modifier= Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor:Color = Color.Blue,
    unselectedColor:Color = Color.LightGray
    ){
   Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize){
            page->
            Box(modifier = Modifier.size(indicatorSize).clip(CircleShape)
                .background(color = if(page==selectedPage)selectedColor else unselectedColor)
            )
        }
   }
}