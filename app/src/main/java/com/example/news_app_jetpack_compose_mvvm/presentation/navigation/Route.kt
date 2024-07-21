package com.example.news_app_jetpack_compose_mvvm.presentation.navigation

sealed class Route(
   val route:String) {
    object OnBoardingScreen: Route("onBoardingScreen")
    object HomeScreen: Route("homeScreen")
    object BookmarkScreen: Route("bookmarkScreen")
    object DetailsScreen: Route("detailsScreen")
    object NewsNavigation: Route("newsNavigation")
     object SearchScreen: Route("searchScreen")
     object AppStartNavigation: Route("appStartNavigation")
    object NewsNavigatorScreen: Route("newsNavigator")

}