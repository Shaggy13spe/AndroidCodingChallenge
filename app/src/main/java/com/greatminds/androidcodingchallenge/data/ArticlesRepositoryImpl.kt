package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val remote: ArticlesRemoteDataSource
) : ArticlesRepository {
    override suspend fun getArticles(): Result<List<Article>> = withContext(Dispatchers.IO) {
        runCatching {
            remote.fetchArticles().map { dto ->
                Article(id = dto.id, title = dto.title, summary = dto.body)
            }
        }
    }
}
