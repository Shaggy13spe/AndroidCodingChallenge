package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto
import javax.inject.Inject

interface ArticlesRemoteDataSource {
    suspend fun fetchArticles(): List<ArticleDto>
}

class ArticlesRemoteDataSourceImpl @Inject constructor() : ArticlesRemoteDataSource {
    override suspend fun fetchArticles(): List<ArticleDto> = emptyList()
}