package com.greatminds.androidcodingchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatminds.androidcodingchallenge.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.greatminds.androidcodingchallenge.model.Article

sealed interface ArticlesUiState {
    object Loading : ArticlesUiState
    data class Success(val items: List<Article>) : ArticlesUiState
    object Empty : ArticlesUiState
    data class Error(val message: String) : ArticlesUiState
}

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading)
    val uiState: StateFlow<ArticlesUiState> = _uiState

    init { refresh() }

    fun refresh() {
        viewModelScope.launch {
            _uiState.value = ArticlesUiState.Loading
            val result = getArticlesUseCase()
            result.fold(onSuccess = { list ->
                _uiState.value = if (list.isEmpty()) ArticlesUiState.Empty else ArticlesUiState.Success(list)
            }, onFailure = { t ->
                _uiState.value = ArticlesUiState.Error(t.localizedMessage ?: "Unknown")
            })
        }
    }
}
