package com.example.news_app_jetpack_compose_mvvm.presentation.news_navigator.components

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.presentation.bottomBarIconSize
import com.example.news_app_jetpack_compose_mvvm.ui_theme.gray1
import com.example.news_app_jetpack_compose_mvvm.ui_theme.gray2

@Composable
fun NewsBottomBar(
    selectedItem:Int,
    onItemClick:(Int)->Unit
){
    Log.d("MainActivity", "Bottom Bar Recreated")


    val tonalElevation = getTonalElevation()

        NavigationBar(
            modifier=Modifier.fillMaxWidth()
            ,containerColor = MaterialTheme.colorScheme.background
            ,tonalElevation = tonalElevation
        ) {
                NavigationBarItem(
                   colors =  navBarItemColors(),
                    selected = selectedItem==0,
                    onClick = {
                        onItemClick(0)},
                    icon = {
                        Column(verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = null,
                                modifier=Modifier.size(bottomBarIconSize)
                            )
                            Text(text = "Home", style = MaterialTheme.typography.labelSmall)
                        }
                    },
                )
                NavigationBarItem(
                    colors =  navBarItemColors(),
                    selected = selectedItem==1,
                    onClick = {
                        onItemClick(1)},
                    icon = {
                        Column(verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = null,
                                modifier=Modifier.size(bottomBarIconSize)
                            )
                            Text(text = "Search", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                )
                NavigationBarItem(
                    colors =  navBarItemColors(),
                    selected = selectedItem==2,
                    onClick = {
                        onItemClick(2)},
                    icon = {
                        Column(verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bookmark),
                            modifier=Modifier.size(bottomBarIconSize),
                            contentDescription = null
                        )
                            Text(text = "Bookmark", style = MaterialTheme.typography.labelSmall)
                        }
                           },
                )
        }
}

@Composable
fun getTonalElevation():Dp{
    return if(isSystemInDarkTheme()) 0.dp else 10.dp
}

@Composable
fun navBarItemColors():NavigationBarItemColors{
    return NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.background,
        selectedIconColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = gray2
    )
}

//@Preview()
//@Composable
//fun PreviewBottomBar(){
//    NewsBottomBar(selectedItem = 1, onItemClick = {})
//}
