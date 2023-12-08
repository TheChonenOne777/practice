package com.example.practice.network.list

import retrofit2.http.GET

interface ListApiRetrofit {
    @GET("")
    suspend fun stations(): ListResponse
}
