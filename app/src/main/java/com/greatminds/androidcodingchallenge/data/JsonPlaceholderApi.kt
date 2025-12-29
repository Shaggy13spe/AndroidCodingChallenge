package com.greatminds.androidcodingchallenge.data

import com.greatminds.androidcodingchallenge.model.ArticleDto
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("posts")
    suspend fun getPosts(): List<ArticleDto>
}