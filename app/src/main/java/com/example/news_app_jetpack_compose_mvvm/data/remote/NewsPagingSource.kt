package com.example.news_app_jetpack_compose_mvvm.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.news_app_jetpack_compose_mvvm.domain.model.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
) :PagingSource<Int,Article>() {

    private var totalNewsCount =0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key?:1
        return try {
            val newsResponse = newsApi.getNews(page=page, sources = sources)
            totalNewsCount+=newsResponse.articles.size
            LoadResult.Page(
                data= newsResponse.articles.distinctBy { it.title },
                nextKey = if(newsResponse.totalResults==totalNewsCount) null else page +1,
                prevKey = if(page==1) null else page-1
            )
        }
        catch (e:Exception){
                LoadResult.Error(
                    throwable = e
                )
        }
    }
}