package com.greatminds.androidcodingchallenge.domain

import com.greatminds.androidcodingchallenge.data.ArticlesRepository
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository
) {
    suspend operator fun invoke() = emptyList<Any>()
}
