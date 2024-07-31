package com.example.news_app_jetpack_compose_mvvm.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.common.ArticleList
import com.example.news_app_jetpack_compose_mvvm.presentation.extraSmallPadding
import com.example.news_app_jetpack_compose_mvvm.presentation.extraSmallPadding2
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1
import com.example.news_app_jetpack_compose_mvvm.presentation.navigation.Route
import com.example.news_app_jetpack_compose_mvvm.presentation.paddingSmall1
import com.example.news_app_jetpack_compose_mvvm.ui_theme.Poppins
import com.example.news_app_jetpack_compose_mvvm.ui_theme.gray1
import com.example.news_app_jetpack_compose_mvvm.ui_theme.gray2
import com.example.news_app_jetpack_compose_mvvm.ui_theme.leagueSpartansFamily

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    onClick:(Article)->Unit
){
    Column(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = mediumPadding1,
                start = mediumPadding1,
                end = mediumPadding1)) {
        Text(
            text = "Bookmarks",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(thickness = 1.dp, color = gray2)
        Spacer(modifier = Modifier.height(mediumPadding1))
        if(state.article.isEmpty())
        {
            EmptyBookmarkScreen()
        }else{
        ArticleList(articles = state.article, onClick = onClick)
        }
    }

}

@Composable
fun EmptyBookmarkScreen(){
    Column(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)) {
        Text(
            text = "No Bookmarks Added!",
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            color = Color.Gray, fontSize = 22.sp
        )
    }
}