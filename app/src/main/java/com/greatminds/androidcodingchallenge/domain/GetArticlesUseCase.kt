package com.greatminds.androidcodingchallenge.domain

import com.greatminds.androidcodingchallenge.data.ArticlesRepository
import com.greatminds.androidcodingchallenge.model.Article
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository
) {
    //Result
    suspend operator fun invoke(): Result<List<Article>> = repository.getArticles()
}
