package com.example.news_app_jetpack_compose_mvvm.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_jetpack_compose_mvvm.data.local.NewsDao
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsDao: NewsDao
) :ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state
    init {
        getArticles()
    }
    private fun getArticles(){
        viewModelScope.launch {
            newsDao.getArticles().onEach { articleList->
                _state.value= _state.value.copy(article = articleList)
            }.collect()
        }
    }
}