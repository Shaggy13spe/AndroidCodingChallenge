package com.greatminds.androidcodingchallenge.presentation.state


sealed interface PostState<out T> {
    data object Loading : PostState<Nothing>
    data class Success<T>(val data: T) : PostState<T>
    data class Error(val message: String, val throwable: Throwable? = null) : PostState<Nothing>

}