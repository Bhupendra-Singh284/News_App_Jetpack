package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding

import android.bluetooth.BluetoothClass.Device
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.news_app_jetpack_compose_mvvm.presentation.common.NewsButton
import com.example.news_app_jetpack_compose_mvvm.presentation.common.NewsTextButton
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.components.OnBoardingPage
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.components.PageIndicator

import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(){
    val pages:List<Page> = getPages()
    val pagerState = rememberPagerState(initialPage = 0){pages.size}
    val buttonState = when(pagerState.currentPage){
                0-> listOf<String>("","Next")
                1-> listOf<String>("Back","Next")
                2-> listOf<String>("Back","Get Started")
                else -> listOf("","")
            }
    Column(Modifier.fillMaxSize()) {
    HorizontalPager(state = pagerState, verticalAlignment = Alignment.Top) { index->
        OnBoardingPage(page = pages[index])
    }

        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .navigationBarsPadding(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

            val coroutineScope = rememberCoroutineScope()

            Box(Modifier.weight(1f,true)){
                PageIndicator(Modifier.width(60.dp),pageSize = pages.size, selectedPage = pagerState.currentPage)
            }

            if(buttonState[0]!=""){
                NewsTextButton(text = buttonState[0]) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(page=pagerState.currentPage-1)
                    }
                }
            }

            NewsButton(text = buttonState[1]) {
                if(pagerState.currentPage==2){

                }else{
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(page=pagerState.currentPage+1)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(40.dp))
    }
}