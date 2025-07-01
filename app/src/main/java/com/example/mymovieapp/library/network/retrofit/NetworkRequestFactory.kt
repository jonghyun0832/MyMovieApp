package com.example.mymovieapp.features.feed.presentation.viewmodel

import com.example.mymovieapp.library.network.model.ApiResult
import com.example.mymovieapp.library.network.model.NetworkRequestInfo
import java.lang.reflect.Type

interface NetworkRequestFactory {

    suspend fun <T> create(
        url: String,
        requestInfo: NetworkRequestInfo = NetworkRequestInfo.Builder().build(),
        type: Type
    ): ApiResult<T>
}
