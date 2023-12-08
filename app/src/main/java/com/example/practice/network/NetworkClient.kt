package com.example.practice.network

import retrofit2.Retrofit

interface NetworkClient {
    fun retrofit(): Retrofit
}