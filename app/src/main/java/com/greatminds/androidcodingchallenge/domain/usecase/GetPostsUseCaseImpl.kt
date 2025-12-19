package com.greatminds.androidcodingchallenge.domain.usecase

import com.greatminds.androidcodingchallenge.domain.model.Post
import com.greatminds.androidcodingchallenge.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCaseImpl @Inject constructor(
    private val repo: PostRepository
) : GetPostsUseCase {
    override suspend fun invoke(): List<Post> = repo.getPosts()
}