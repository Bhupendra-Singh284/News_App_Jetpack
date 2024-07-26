package com.example.news_app_jetpack_compose_mvvm.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.presentation.details.DetailsViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeState
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingEvent
import com.example.news_app_jetpack_compose_mvvm.presentation.search.SearchScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.search.SearchViewModel

@Composable
fun NavigationGraph(
    startDestination:String
){
    Log.d("MainViewModel","Inside Navigation graph ")
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            startDestination=Route.OnBoardingScreen.route,
            route=Route.AppStartNavigation.route
        ){
            composable(route=Route.OnBoardingScreen.route){
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onGetStartedClicked = {event:OnBoardingEvent->onBoardingViewModel.onEvent(event)})
            }
        }
        navigation(startDestination= Route.NewsNavigatorScreen.route,route=Route.NewsNavigation.route){
            composable(route = Route.NewsNavigatorScreen.route){
                val homeViewModel:HomeViewModel = hiltViewModel()
                val articles = homeViewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    state = HomeState(),
                    articles = articles,
                    navigateToSearch = {},
                    navigateToDetails = {}
                )
                 }
            }
        }
    }


