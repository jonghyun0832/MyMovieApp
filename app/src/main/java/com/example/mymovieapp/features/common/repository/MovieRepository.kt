package com.example.mymovieapp.features.common.repository

import com.example.mymovieapp.features.common.network.api.IMovieAppNetworkApi
import com.example.mymovieapp.library.network.model.ApiResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi
): IMovieDataSource {
    override suspend fun getMovieList() {
        val data = movieNetworkApi.getMovies().response
        if (data is ApiResponse.Success) {
            val movieList = data.data
        }
    }
}