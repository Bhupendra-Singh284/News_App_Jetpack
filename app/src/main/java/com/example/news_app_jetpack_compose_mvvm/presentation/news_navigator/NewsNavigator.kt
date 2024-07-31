package com.example.news_app_jetpack_compose_mvvm.presentation.news_navigator

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.presentation.bookmark.BookMarkViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.bookmark.BookmarkScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.details.DetailsScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.details.DetailsViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeState
import com.example.news_app_jetpack_compose_mvvm.presentation.home.HomeViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.navigation.Route
import com.example.news_app_jetpack_compose_mvvm.presentation.news_navigator.components.NewsBottomBar
import com.example.news_app_jetpack_compose_mvvm.presentation.search.SearchScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.search.SearchViewModel

@Composable
fun NewsNavigator(){
    Log.d("MainActivity", "News Navigator Recreated")

    val navController = rememberNavController()


    val backStackState= navController.currentBackStackEntryAsState()

    Log.d("MainActivity","CurrentDestination: ${navController.currentDestination?.route}, BackStack Size: ${backStackState.value?.destination?.hierarchy?.count()}")

    val isBottomBarVisible = remember(key1 = backStackState.value) {
        when(backStackState.value?.destination?.route){
            Route.DetailsScreen.route-> false
            null->false
            else->true
        }
    }

    Log.d("MainActivity", "Destination:${navController.currentDestination?.route}, isBottomBarVisible:$isBottomBarVisible")
    var selectedItem:Int by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem= when(backStackState.value?.destination?.route){
        Route.HomeScreen.route->0
        Route.SearchScreen.route->1
        Route.BookmarkScreen.route->2
        else->0
    }

    Scaffold(
        bottomBar = {
            if(isBottomBarVisible) {
                NewsBottomBar(selectedItem, onItemClick = { index ->
                    when (index) {
                        0 -> {
                            navigateToTab(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )
                        }
                        1 -> {
                            navigateToTab(
                                navController = navController,
                                route = Route.SearchScreen.route
                            )
                        }
                        2 -> {
                            navigateToTab(
                                navController = navController,
                                route = Route.BookmarkScreen.route
                            )
                        }
                    }
                })
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            modifier = Modifier.padding(bottom=bottomPadding),
            navController = navController,
            startDestination = Route.HomeScreen.route
        ){

            composable(route=Route.SearchScreen.route) {
                val searchViewModel:SearchViewModel = hiltViewModel()
                OnBackClickStateSaver(navController)
                SearchScreen(
                    state = searchViewModel.state.value,
                    onEvent = searchViewModel::onEvent,
                    navigateToDetails = {
                        article ->
                        Log.d("MainActivity","details Nav called , article: ${article.title}")
                        navigateToDetails(navController,article)
                    }
                )
            }

            composable(route=Route.BookmarkScreen.route) {
                val bookMarkViewModel:BookMarkViewModel = hiltViewModel()
                OnBackClickStateSaver(navController)
                BookmarkScreen(
                    state = bookMarkViewModel.state.value,
                    onClick = {
                        article -> navigateToDetails(navController = navController,article)
                    }
                )
            }


            composable(route=Route.DetailsScreen.route) {
                Log.d("MainActivity","Inside detail screen route")
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")?.let{
                    article->
                    Log.d("MainActivity","Article Received")
                    BackHandler {
                        navController.previousBackStackEntry?.savedStateHandle?.remove<Article>("article")
                        navController.popBackStack()
                    }
                    val detailsViewModel:DetailsViewModel = hiltViewModel()
                    DetailsScreen(
                        state = detailsViewModel.state.value,
                        article = article,
                        onEvent = detailsViewModel::onEvent,
                        navigateBack = {
                            navController.previousBackStackEntry?.savedStateHandle?.remove<Article>("article")
                            navController.popBackStack()}
                    )
                    detailsViewModel.checkArticlePresentInBookmark(article)
                }
            }

            composable(route=Route.HomeScreen.route) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                val articles = homeViewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    state = HomeState(),
                    articles = articles,
                    navigateToSearch = {
                        navigateToTab(navController,Route.SearchScreen.route)
                    },
                    navigateToDetails = {
                        article-> navigateToDetails(navController,article)
                    }
                )
            }
        }
    }
}

fun navigateToTab(navController:NavController,route:String){
    navController.navigate(route){
        navController.graph.startDestinationRoute?.let{route->
            popUpTo(route){
                saveState=true
            }
        }
        restoreState=true
        launchSingleTop=true
    }
}

fun navigateToDetails(navController: NavController,article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article",article)
    navController.navigate(Route.DetailsScreen.route)
}

@Composable
fun OnBackClickStateSaver(navController: NavController){
    BackHandler {
        navigateToTab(navController,Route.HomeScreen.route)
    }
}