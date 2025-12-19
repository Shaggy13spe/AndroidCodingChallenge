package com.greatminds.androidcodingchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatminds.androidcodingchallenge.domain.model.Post
import com.greatminds.androidcodingchallenge.domain.usecase.GetPostsUseCase
import com.greatminds.androidcodingchallenge.presentation.state.PostState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PostViewModel@Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _postsState = MutableStateFlow<PostState<List<Post>>>(PostState.Loading)
    val postsState: StateFlow<PostState<List<Post>>> = _postsState.asStateFlow()

    init { loadPosts() }

    fun loadPosts() {
        _postsState.value = PostState.Loading

        viewModelScope.launch {
            try {
                val posts = getPostsUseCase()
                _postsState.value = PostState.Success(posts)
            } catch (e: IOException) {
                _postsState.value = PostState.Error("Network error. Check internet.", e)
            } catch (e: HttpException) {
                _postsState.value = PostState.Error("Server error (${e.code()}). Try again.", e)
            } catch (t: Throwable) {
                _postsState.value = PostState.Error(t.message ?: "Something went wrong.", t)
            }
        }
    }
}