package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto

interface ArticlesRemoteDataSource {
    suspend fun fetchArticles(): List<ArticleDto>
}
