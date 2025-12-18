package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto
import javax.inject.Inject

class ArticlesRemoteDataSourceImpl @Inject constructor(
    private val api: JsonPlaceholderApi
) : ArticlesRemoteDataSource {
    override suspend fun fetchArticles(): List<ArticleDto> = api.getPosts()
}
