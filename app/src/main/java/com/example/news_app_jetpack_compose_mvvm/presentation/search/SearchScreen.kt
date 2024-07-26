package com.example.news_app_jetpack_compose_mvvm.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.common.ArticleList
import com.example.news_app_jetpack_compose_mvvm.presentation.common.SearchBar
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1

@Composable
fun SearchScreen(
    state:SearchState,
    onEvent:(SearchEvent)->Unit,
    navigateToDetails:(Article)->Unit
){
    Column(
        Modifier
            .padding(top = mediumPadding1, start = mediumPadding1, end = mediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.query, readOnly = false,
            onValueChange = { onEvent(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { onEvent(SearchEvent.SearchNews) } ,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles = articles, onClick = navigateToDetails)
        }
    }
}