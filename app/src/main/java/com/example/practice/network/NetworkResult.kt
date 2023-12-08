package com.example.practice.network

import retrofit2.HttpException

sealed class NetworkResult<T> {
    class Success<T>(val data: T) : NetworkResult<T>()
    class HttpError<T>(val code: Int, val body: String) : NetworkResult<T>()
    class Error<T>(val t: Throwable) : NetworkResult<T>()
}

inline fun <reified T : Any> asNetworkResult(request: () -> T): NetworkResult<T> =
    try {
        NetworkResult.Success(request.invoke())
    } catch (e: Exception) {
        when (e) {
            is HttpException -> {
                NetworkResult.HttpError(
                    code = e.response()?.code() ?: 0,
                    body = e.response()?.errorBody()?.string().orEmpty()
                )
            }

            else -> NetworkResult.Error(e)
        }
    }
