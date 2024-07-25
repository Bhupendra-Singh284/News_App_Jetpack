package com.example.news_app_jetpack_compose_mvvm.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.news_app_jetpack_compose_mvvm.R
import com.example.news_app_jetpack_compose_mvvm.ui_theme.News_app_jetpack_compose_mvvmTheme

@Composable
fun SearchBar(
    modifier:Modifier=Modifier,
    text:String,
    readOnly:Boolean,
    onValueChange:(String)->Unit,
    onSearch:()->Unit,
    onClick:()->Unit
) {
    val isDarkMode = isSystemInDarkTheme()
    var newModifier = modifier
    if(!isDarkMode){
       newModifier = modifier.border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium)
    }
        Box(modifier=newModifier.clickable { onClick() }){
            TextField(value = text, onValueChange = onValueChange
            ,readOnly=readOnly,
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_search), tint = MaterialTheme.colorScheme.onBackground, contentDescription = null)
                },

                placeholder = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch={
                        onSearch()
                    }
                ),
                textStyle = MaterialTheme.typography.bodySmall,
                modifier=Modifier.fillMaxWidth()
            )
        }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    News_app_jetpack_compose_mvvmTheme {
        SearchBar(text = "", onValueChange = {}, readOnly = false, onSearch = {}) {

        }
    }
}