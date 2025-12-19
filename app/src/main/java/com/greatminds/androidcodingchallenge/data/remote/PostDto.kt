package com.greatminds.androidcodingchallenge.data.remote

import com.greatminds.androidcodingchallenge.domain.model.Post


data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun PostDto.toDomain(): Post = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)