package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ArticlesRemoteDataSource {
    suspend fun fetchArticles(): List<ArticleDto>
}

class ArticlesRemoteDataSourceImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ArticlesRemoteDataSource {
    override suspend fun fetchArticles(): List<ArticleDto> = withContext(dispatcher) {
      api.getPosts()
    }
}
