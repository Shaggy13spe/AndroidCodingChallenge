package com.greatminds.androidcodingchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatminds.androidcodingchallenge.domain.GetArticlesUseCase
import com.greatminds.androidcodingchallenge.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface ArticlesUiState {
    object Loading : ArticlesUiState
    data class Success (val items: List<Article>) : ArticlesUiState
    object Empty : ArticlesUiState
    data class Error(val message: String) : ArticlesUiState
}

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading)
//    val uiState: StateFlow<ArticlesUiState> = _uiState
    val uiState: StateFlow<ArticlesUiState> = _uiState.asStateFlow()

    init {
        fetchArticles()
    }

     fun fetchArticles() {
        viewModelScope.launch {
            _uiState.value = ArticlesUiState.Loading

            getArticlesUseCase()
                //handle empty / non empty cases
                .onSuccess { articles ->
                    _uiState.value = if (articles.isEmpty()) {
                        ArticlesUiState.Empty
                    } else  {
                        ArticlesUiState.Success (articles)
                    }
                }
                .onFailure { error->
                    _uiState.value = ArticlesUiState.Error(
                        message = error.message?: "unknown error"
                    )
                }
        }
    }
}

