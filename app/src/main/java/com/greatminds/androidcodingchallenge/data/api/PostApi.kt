package com.greatminds.androidcodingchallenge.data.api

import com.greatminds.androidcodingchallenge.data.remote.PostDto
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}