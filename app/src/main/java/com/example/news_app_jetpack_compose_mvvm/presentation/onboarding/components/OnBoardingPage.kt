package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.news_app_jetpack_compose_mvvm.presentation.paddingSmall1
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.Page

@Composable
fun OnBoardingPage(
    modifier:Modifier=Modifier,
    page: Page
){
    Column(modifier=modifier.fillMaxWidth()) {
        Image(painter = painterResource(page.image), contentDescription = null,
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f), contentScale = ContentScale.Crop)
        OnBoardingPageTexts(page)
    }
}

@Composable
fun OnBoardingPageTexts(page:Page) {
    Column(modifier = Modifier.fillMaxWidth().height(230.dp).padding(horizontal = 20.dp)){
        Spacer(modifier = Modifier.height(14.dp))
        Text(page.title,Modifier, color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(paddingSmall1))
        Text(page.description, color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.bodyMedium)
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewOnboardingPage(){
//    val p = Page(stringResource(id = R.string.onboarding_title1),stringResource(id = R.string.onboarding_description1),R.drawable.sports)
//    OnBoardingPage(page = p)
//}