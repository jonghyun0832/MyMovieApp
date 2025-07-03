package com.example.mymovieapp.features.detail.domain.usecase.di

import com.example.mymovieapp.features.detail.domain.usecase.GetMovieDetailUseCase
import com.example.mymovieapp.features.detail.domain.usecase.IGetMovieDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailUseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetMovieDetailUseCase(getMovieDetailUseCase: GetMovieDetailUseCase): IGetMovieDetailUseCase
}
