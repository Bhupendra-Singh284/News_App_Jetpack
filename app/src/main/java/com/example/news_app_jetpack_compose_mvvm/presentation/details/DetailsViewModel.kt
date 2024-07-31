package com.example.news_app_jetpack_compose_mvvm.presentation.details

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.DeleteArticle
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.GetSpecifiedArticle
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.InsertArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val insertArticle: InsertArticle,
    private val getSpecifiedArticle: GetSpecifiedArticle,
    private val deleteArticle: DeleteArticle
):ViewModel() {

    private val _state = mutableStateOf(DetailsState())
    val state: State<DetailsState> = _state

    fun onEvent(detailEvent: DetailEvent){
        when(detailEvent)
        {
            is DetailEvent.Bookmark->{
                insertOrDeleteArticle(detailEvent.article)
            }
        }
    }

    private fun insertOrDeleteArticle(article:Article){
        viewModelScope.launch {
            if(getSpecifiedArticle(article.url)==null){
                insertArticle(article)
                _state.value = _state.value.copy(articleBookmarked = true)
            }else{
                deleteArticle(article)
                _state.value = _state.value.copy(articleBookmarked = false)
            }
        }
    }


    fun checkArticlePresentInBookmark(article: Article){
        viewModelScope.launch {
            if(getSpecifiedArticle(article.url)!=null){
                _state.value= _state.value.copy(articleBookmarked = true)
            }
        }
    }
}