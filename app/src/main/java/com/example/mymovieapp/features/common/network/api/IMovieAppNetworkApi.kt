package com.example.mymovieapp.features.common.network.api

import com.example.mymovieapp.features.common.network.model.MovieResponse
import com.example.mymovieapp.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}