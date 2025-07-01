package com.example.mymovieapp.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}