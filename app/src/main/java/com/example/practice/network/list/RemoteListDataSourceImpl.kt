package com.example.practice.network.list

import com.example.practice.network.NetworkClient
import com.example.practice.network.NetworkResult
import com.example.practice.network.asNetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteListDataSourceImpl @Inject constructor(private val client: NetworkClient) : RemoteListDataSource {

    private val methods by lazy { client.retrofit().create(ListApiRetrofit::class.java) }

    override suspend fun requestList(): NetworkResult<ListResponse> = withContext(Dispatchers.IO) {
        asNetworkResult { methods.stations() }
    }
}