package com.example.mymovieapp.features.feed.presentation.input

interface IFeedViewModelInput {
    fun openDetail(movieName: String)
    fun openInfoDialog()
    fun refreshFeed()
}