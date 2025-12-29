package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.Article
import com.greatminds.androidcodingchallenge.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ArticlesRepository {
    suspend fun getArticles(): Result<List<Article>>
}

class ArticlesRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArticlesRemoteDataSource
) : ArticlesRepository {

    //use io dispatch thread .. fetch ... map dto ...
    override suspend fun getArticles(): Result<List<Article>> =withContext(Dispatchers.IO) {
        try {
            val articles = remoteDataSource.fetchArticles()
                .map { it.toDomain() }
            Result.success(articles)
        } catch (e: Exception) {
            Result.failure(e)
         }
    }
}