package com.example.news_app_jetpack_compose_mvvm.presentation.details

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.news_app_jetpack_compose_mvvm.domain.model.Source
import com.example.news_app_jetpack_compose_mvvm.presentation.articleImageHeight
import com.example.news_app_jetpack_compose_mvvm.presentation.details.components.DetailsAppBar
import com.example.news_app_jetpack_compose_mvvm.presentation.mediumPadding1
import com.example.news_app_jetpack_compose_mvvm.presentation.paddingSmall1
import com.example.news_app_jetpack_compose_mvvm.ui_theme.News_app_jetpack_compose_mvvmTheme

@Composable
fun DetailsScreen(
    article: Article,
    onEvent: (DetailEvent)->Unit,
    navigateBack:()->Unit
){
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
           .statusBarsPadding()
            .background(color = MaterialTheme.colorScheme.background)) {
        DetailsAppBar(
            onBackClick = {navigateBack()},
            onBookmarkClick = {onEvent(DetailEvent.bookmark)},
            onShareClick = {
                           Intent(Intent.ACTION_SEND).also {
                               it.putExtra(Intent.EXTRA_TEXT,article.url)
                               if (it.resolveActivity(context.packageManager) != null) {
                                   context.startActivity(it)
                               }}
                           },
            onBrowseClick = {
                Intent(Intent.ACTION_VIEW).also{
                    it.data= Uri.parse(article.url)
                    if(it.resolveActivity(context.packageManager)!=null){
                        context.startActivity(it)
                    }
                }
            }
        )
        LazyColumn(Modifier.padding(horizontal = mediumPadding1)){
            item {
                AsyncImage(modifier= Modifier
                    .fillMaxWidth()
                    .height(articleImageHeight)
                    .clip(MaterialTheme.shapes.medium), model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage).build(),
                    contentDescription = null, contentScale = ContentScale.Crop)
                Spacer(modifier = Modifier.height(mediumPadding1))
                Text(text = article.title, style = MaterialTheme.typography.titleLarge, maxLines = 2, overflow = TextOverflow.Ellipsis, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.height(paddingSmall1))
                Text(text = article.content, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    News_app_jetpack_compose_mvvmTheme(dynamicColor = false) {
        DetailsScreen(
            article = Article(
                author = "",
                title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
                publishedAt = "2023-06-16T22:24:33Z",
                source = Source(
                    id = "", name = "bbc"
                ),
                url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
                urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
            ),
            onEvent = {},
            navigateBack = {}
        )
    }
}