package com.greatminds.androidcodingchallenge.model


data class Article(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)

fun ArticleDto.toDomain(): Article = Article (
    id = id,
    userId = userId,
    title = title,
    body = body
)

/*
*
*  userId`
- `id`
- `title`
- `body`
* */

