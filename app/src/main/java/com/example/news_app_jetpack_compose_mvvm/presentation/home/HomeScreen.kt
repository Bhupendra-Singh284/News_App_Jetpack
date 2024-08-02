package com.example.news_app_jetpack_compose_mvvm.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.presentation.common.ArticleList
import com.example.news_app_jetpack_compose_mvvm.presentation.common.SearchBar
import com.example.news_app_jetpack_compose_mvvm.ui_theme.Poppins
import com.example.news_app_jetpack_compose_mvvm.ui_theme.appIconBlue
import com.example.news_app_jetpack_compose_mvvm.ui_theme.leagueSpartansFamily

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    articles:LazyPagingItems<Article>,
    navigateToSearch:()->Unit,
    navigateToDetails:(Article)->Unit
){
    Column(
        modifier
            .fillMaxSize()
            .statusBarsPadding()
             .background(color = MaterialTheme.colorScheme.background)
    ) {
        Row(Modifier.fillMaxWidth().padding(horizontal = mediumPadding1, vertical = 15.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.app_icon_home_screen),
                alignment = Alignment.CenterEnd,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier= Modifier
                    .padding(end = 10.dp)
                    .size(width = 50.dp, height = 40.dp)
            )
            Text(text = "NEWS POINT", fontFamily = leagueSpartansFamily, fontWeight = FontWeight.Bold, fontSize = 27.sp, color = MaterialTheme.colorScheme.primary)
        }
            
       // Spacer(modifier = Modifier.height(mediumPadding1))
        SearchBar(
            modifier= Modifier
                .padding(horizontal = mediumPadding1)
                .padding(bottom = 4.dp)
                .fillMaxWidth(),
            text="",
            readOnly = true,
            onValueChange= {},
            onSearch = {},
            onClick = {navigateToSearch()}
        )
        Spacer(modifier = Modifier.height(15.dp))
        ArticleList(modifier=Modifier.padding(horizontal = mediumPadding1),articles = articles, onClick = navigateToDetails)
    }
}