package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.Article

interface ArticlesRepository {
    suspend fun getArticles(): Result<List<Article>>
}
