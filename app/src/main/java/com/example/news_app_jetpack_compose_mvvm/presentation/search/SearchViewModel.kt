package com.example.news_app_jetpack_compose_mvvm.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.news_app_jetpack_compose_mvvm.domain.use_cases.news.SearchNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchNews: SearchNews
) :ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event:SearchEvent){
        when(event){
            is SearchEvent.SearchNews->{
                search()
            }
            is SearchEvent.UpdateSearchQuery->{
                _state.value= state.value.copy(query = event.query)
            }
        }
    }

   private fun search(){
       val articles= searchNews(_state.value.query, sources = listOf("bbc-news","abc-news","al-jazeera-english")).cachedIn(viewModelScope)
        _state.value= _state.value.copy(articles=articles)
   }
}