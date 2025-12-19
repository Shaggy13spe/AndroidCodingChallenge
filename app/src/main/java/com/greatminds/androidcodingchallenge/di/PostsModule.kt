package com.greatminds.androidcodingchallenge.di

import com.greatminds.androidcodingchallenge.data.repo.PostRepositoryImpl
import com.greatminds.androidcodingchallenge.domain.repository.PostRepository
import com.greatminds.androidcodingchallenge.domain.usecase.GetPostsUseCase
import com.greatminds.androidcodingchallenge.domain.usecase.GetPostsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostsModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(
        impl: PostRepositoryImpl
    ): PostRepository

    @Binds
    abstract fun bindGetPostsUseCase(
        impl: GetPostsUseCaseImpl
    ): GetPostsUseCase
}