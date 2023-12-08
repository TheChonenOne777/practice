package com.example.practice.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitClient @Inject constructor(): NetworkClient {

    private val gson = Gson()
    private val okhttp by lazy { createOkhttp() }
    private val retrofit by lazy { createRetrofit() }

    override fun retrofit(): Retrofit = retrofit

    private fun createOkhttp(): OkHttpClient =
        OkHttpClient.Builder()
            // TODO: add interceptors, timeouts, etc.
            .build()

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            // TODO: add okhttp client, gson
            .build()

    companion object {
        private const val BASE_URL = "http://www.radio-browser.info/webservice/json"
    }
}