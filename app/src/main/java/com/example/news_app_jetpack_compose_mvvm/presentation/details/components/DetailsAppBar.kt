package com.example.news_app_jetpack_compose_mvvm.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.ui_theme.appIconBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsAppBar(
    isBookmarked:Boolean = false,
    onBackClick:()->Unit,
    onBookmarkClick:()->Unit,
    onShareClick:()->Unit,
    onBrowseClick:()->Unit
){
    TopAppBar(title = {},
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground),
        navigationIcon = {
            IconButton(onClick = {onBackClick()}) {
                Icon(painter = painterResource(id = R.drawable.ic_back_arrow), contentDescription =null )
            }
        },
        actions = {
            IconButton(onClick = {onBookmarkClick()}) {
                Icon( painter = painterResource(id = R.drawable.ic_bookmark), tint = if(isBookmarked) appIconBlue else MaterialTheme.colorScheme.onBackground, contentDescription =null )
            }
            IconButton(onClick = {onShareClick()}) {
                Icon(imageVector = Icons.Outlined.Share, contentDescription =null )
            }
            IconButton(onClick = {onBrowseClick()}) {
                Icon(painter = painterResource(id = R.drawable.ic_network), contentDescription =null )
            }
        }
        )
}