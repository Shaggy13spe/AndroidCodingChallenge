package com.greatminds.androidcodingchallenge.domain.usecase

import com.greatminds.androidcodingchallenge.domain.model.Post

// placeholder
fun interface GetPostsUseCase {
    suspend operator fun invoke(): List<Post>
}