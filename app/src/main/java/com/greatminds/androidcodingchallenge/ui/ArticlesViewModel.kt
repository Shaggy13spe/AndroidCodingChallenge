package com.greatminds.androidcodingchallenge.ui

import androidx.lifecycle.ViewModel
import com.greatminds.androidcodingchallenge.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed interface ArticlesUiState {
    object Loading : ArticlesUiState
    data class Success(val items: List<com.greatminds.androidcodingchallenge.model.Article>) : ArticlesUiState
    object Empty : ArticlesUiState
    data class Error(val message: String) : ArticlesUiState
}

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading)
    val uiState: StateFlow<ArticlesUiState> = _uiState
}
