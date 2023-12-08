package com.example.practice.base

sealed class ResultModel<T> {
    class Success<Data>(val data: Data) : ResultModel<Data>()
    class Error<T>(t: Throwable) : ResultModel<T>()
    // TODO: add loading state
}

fun <T> T.asResult() = ResultModel.Success(this)

fun <T> Throwable.asResult() = ResultModel.Error<T>(this) // T type does not matter
