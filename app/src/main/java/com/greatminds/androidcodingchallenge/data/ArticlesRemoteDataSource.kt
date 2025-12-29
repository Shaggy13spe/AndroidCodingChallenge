package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto
import javax.inject.Inject

//fetching ARTICLES
interface ArticlesRemoteDataSource {
    suspend fun fetchArticles(): List<ArticleDto>
}

class ArticlesRemoteDataSourceImpl @Inject constructor(
    private val api: JsonPlaceholderApi
) : ArticlesRemoteDataSource {

    override suspend fun fetchArticles(): List<ArticleDto> =api.getPosts()
}