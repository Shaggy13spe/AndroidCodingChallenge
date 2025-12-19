package com.greatminds.androidcodingchallenge.data.repo

import com.greatminds.androidcodingchallenge.data.api.PostApi
import com.greatminds.androidcodingchallenge.data.remote.toDomain
import com.greatminds.androidcodingchallenge.domain.model.Post
import com.greatminds.androidcodingchallenge.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
) : PostRepository {
    override suspend fun getPosts(): List<Post> =
        api.getPosts().map { it.toDomain() }
}