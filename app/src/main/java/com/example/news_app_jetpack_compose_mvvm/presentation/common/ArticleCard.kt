package com.example.news_app_jetpack_compose_mvvm.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.domain.model.Source
import com.example.news_app_jetpack_compose_mvvm.presentation.articleCardSize
import com.example.news_app_jetpack_compose_mvvm.presentation.article_Card_Small_Icon_Size
import com.example.news_app_jetpack_compose_mvvm.presentation.extraSmallPadding
import com.example.news_app_jetpack_compose_mvvm.ui_theme.News_app_jetpack_compose_mvvmTheme
import androidx.compose.ui.unit.dp

@Composable
fun ArticleCard(
    modifier: Modifier=Modifier,
    article: Article,
    onClick:((Article)->Unit)?= null
){
    val context = LocalContext.current
    Row(
        modifier.clickable{onClick?.invoke(article)}
    ) {
        AsyncImage(
            modifier = Modifier
            .size(articleCardSize)
            .padding(vertical = 4.dp)
            .clip(MaterialTheme.shapes.medium),
            contentDescription = "Article Image",
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context = context)
                .data(article.urlToImage)
                .build()
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier= Modifier
                .padding(extraSmallPadding)
                .height(articleCardSize)
        ) {
            Text(
                article.title?:"",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source?.name?:"",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.padding(extraSmallPadding))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription ="",
                    modifier=Modifier.size(article_Card_Small_Icon_Size)
                )
                Spacer(modifier = Modifier.padding(extraSmallPadding))
                Text(
                    maxLines = 1,
                    text =  article.publishedAt?:"",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun ArticleCardPreview() {
//    News_app_jetpack_compose_mvvmTheme(dynamicColor = false) {
//        ArticleCard(
//            article = Article(
//                author = "",
//                content = "",
//                description = "",
//                publishedAt = "2 hours",
//                source = Source(id = "", name = "BBC"),
//                title = "Her train broke down. Her phone died. And then she met her Saver in a",
//                url = "",
//                urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
//            ), onClick = {}
//        )
//    }
//}