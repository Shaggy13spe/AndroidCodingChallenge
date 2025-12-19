package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ArticlesRepository {
    suspend fun getArticles(): Result<List<Article>>
}

class ArticlesRepositoryImpl @Inject constructor() : ArticlesRepository {
    override suspend fun getArticles(): Result<List<Article>> = Result.success(emptyList())
}