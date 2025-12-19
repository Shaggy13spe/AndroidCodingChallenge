package com.greatminds.androidcodingchallenge.domain

import com.greatminds.androidcodingchallenge.data.ArticlesRepository
import com.greatminds.androidcodingchallenge.ui.ArticlesUiState
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository
) {
    suspend operator fun invoke(): ArticlesUiState =
      ArticlesUiState.Success(
        repository.getArticles().getOrDefault(emptyList())
      )
}
