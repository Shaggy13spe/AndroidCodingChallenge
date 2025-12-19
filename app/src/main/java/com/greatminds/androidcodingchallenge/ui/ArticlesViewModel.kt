package com.greatminds.androidcodingchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatminds.androidcodingchallenge.domain.GetArticlesUseCase
import com.greatminds.androidcodingchallenge.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ArticlesUiState {
    object Loading : ArticlesUiState
    data class Success(
      val items: List<com.greatminds.androidcodingchallenge.model.Article>) : ArticlesUiState
    object Empty : ArticlesUiState
    data class Error(val message: String) : ArticlesUiState
}

sealed interface ArticlesUiEvent {
  data object Refresh : ArticlesUiEvent
  data class ItemClick(val item: Article) : ArticlesUiEvent
}

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading)
    val uiState: StateFlow<ArticlesUiState> = _uiState

  init {
    viewModelScope.launch {
      _uiState.value = getArticlesUseCase()
    }
  }

  fun onEvent(event: ArticlesUiEvent) {
    when (event) {
      is ArticlesUiEvent.ItemClick -> {
        _uiState.value = ArticlesUiState.Success(
          items = (_uiState.value as ArticlesUiState.Success).items.map { item ->
            if (item === event.item) {
              item.copy(isExpanded = item.isExpanded.not())
            } else {
              item
            }
          },
        )
      }

      is ArticlesUiEvent.Refresh -> {
        viewModelScope.launch {
          _uiState.value = ArticlesUiState.Loading
          _uiState.value = getArticlesUseCase()
        }
      }
    }
  }
}
