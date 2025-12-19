package com.greatminds.androidcodingchallenge.di

import com.greatminds.androidcodingchallenge.data.ArticlesRemoteDataSource
import com.greatminds.androidcodingchallenge.data.ArticlesRemoteDataSourceImpl
import com.greatminds.androidcodingchallenge.data.ArticlesRepository
import com.greatminds.androidcodingchallenge.data.ArticlesRepositoryImpl
import com.greatminds.androidcodingchallenge.data.JsonPlaceholderApi
import com.greatminds.androidcodingchallenge.domain.GetArticlesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingsModule {
    @Binds
    abstract fun bindRemoteDataSource(impl: ArticlesRemoteDataSourceImpl): ArticlesRemoteDataSource

    @Binds
    abstract fun bindRepository(impl: ArticlesRepositoryImpl): ArticlesRepository
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
  
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    @Provides
    @Singleton
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(logger).build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideJsonPlaceholderApi(retrofit: Retrofit): JsonPlaceholderApi =
        retrofit.create(JsonPlaceholderApi::class.java)

    @Provides
    @Singleton
    fun provideGetArticlesUseCase(repository: ArticlesRepository): GetArticlesUseCase =
        GetArticlesUseCase(repository)
}
