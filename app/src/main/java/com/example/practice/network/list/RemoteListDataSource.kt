package com.example.practice.network.list

import com.example.practice.network.NetworkResult

interface RemoteListDataSource {
    suspend fun requestList(): NetworkResult<ListResponse>
}