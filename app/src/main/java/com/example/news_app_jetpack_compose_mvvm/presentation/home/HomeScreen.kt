package com.example.news_app_jetpack_compose_mvvm.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.presentation.common.ArticleList
import com.example.news_app_jetpack_compose_mvvm.presentation.common.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state:HomeState,
    articles:LazyPagingItems<Article>,
    navigateToSearch:()->Unit,
    navigateToDetails:(Article)->Unit
){
    Column(
        modifier
            .fillMaxSize()
            .padding(top = mediumPadding1)
            .statusBarsPadding()
    ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier= Modifier
                    .size(width = 150.dp, height = 30.dp)
                    .padding(horizontal = mediumPadding1)
            )
        Spacer(modifier = Modifier.height(mediumPadding1))
        SearchBar(
            modifier= Modifier
                .padding(horizontal = mediumPadding1)
                .fillMaxWidth(),
            text="",
            readOnly = true,
            onValueChange= {},
            onSearch = {},
            onClick = navigateToSearch
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        ArticleList(modifier=Modifier.padding(horizontal = mediumPadding1),articles = articles, onClick = navigateToDetails)
    }
}