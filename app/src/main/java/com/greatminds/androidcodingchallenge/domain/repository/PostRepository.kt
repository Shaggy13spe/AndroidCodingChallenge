package com.greatminds.androidcodingchallenge.domain.repository

import com.greatminds.androidcodingchallenge.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}