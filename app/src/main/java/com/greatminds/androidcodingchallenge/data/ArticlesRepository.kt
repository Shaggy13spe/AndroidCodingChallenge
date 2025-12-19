package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.Article
import javax.inject.Inject

interface ArticlesRepository {
    suspend fun getArticles(): Result<List<Article>>
}

class ArticlesRepositoryImpl @Inject constructor(
  private val dataSource: ArticlesRemoteDataSource
) : ArticlesRepository {
  // TODO: ERROR returns {@link Result.error}
    override suspend fun getArticles(): Result<List<Article>> =
      Result.success(
        dataSource.fetchArticles().map { Article(it.id, it.title, it.body, it.userId) }
      );

}
