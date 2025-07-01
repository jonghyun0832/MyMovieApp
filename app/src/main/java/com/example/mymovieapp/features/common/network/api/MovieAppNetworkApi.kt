package com.example.mymovieapp.features.common.network.api

import com.example.mymovieapp.features.common.network.model.MovieResponse
import com.example.mymovieapp.features.feed.presentation.viewmodel.NetworkRequestFactory
import com.example.mymovieapp.library.network.model.ApiResult
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MovieAppNetworkApi @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
): IMovieAppNetworkApi {
    override suspend fun getMovies(): ApiResult<List<MovieResponse>> {
        return networkRequestFactory.create(
            url = "top250.json",
            type = object : TypeToken<List<MovieResponse>>(){}.type
        )
    }
}