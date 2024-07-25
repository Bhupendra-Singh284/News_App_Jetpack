package com.example.news_app_jetpack_compose_mvvm.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.extraSmallPadding
import com.example.news_app_jetpack_compose_mvvm.presentation.extraSmallPadding2
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1
import com.example.news_app_jetpack_compose_mvvm.presentation.paddingSmall1
import kotlinx.coroutines.flow.Flow

@Composable
fun ArticleList(
    modifier:Modifier=Modifier,
    articles: LazyPagingItems<Article>,
    onClick:(Article)->Unit
){
    val handlePagingResult = handlePagingResult(articles)
    if(handlePagingResult){
        LazyColumn(
            modifier=modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            ) {
            items(count= articles.itemCount)
            {
                articles[it]?.let {
                    article-> ArticleCard(
                    article = article,
                    onClick = {onClick(article)}
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Article>):Boolean{
    val loadState = articles.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.refresh as LoadState.Error
        else->null
    }

    return when{
        loadState.refresh is LoadState.Loading->{
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
            false
        }
        error!=null->{
            ErrorScreen()
            false
        }
        else-> true
    }
}
@Composable
fun ErrorScreen(){
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 150.dp)
                , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier=Modifier.size(100.dp) ,
                imageVector = Icons.Sharp.Info,
                contentDescription = "",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "OOPS! Something went wrong\n, Please try again later",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }
}