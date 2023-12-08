package com.example.practice.network.list

import com.example.practice.network.NetworkResult
import javax.inject.Inject

// TODO: delete this after real api is implemented
class MockDataSource @Inject constructor() : RemoteListDataSource {
    override suspend fun requestList(): NetworkResult<ListResponse> {
        return NetworkResult.Success(
            ListResponse(
                listOf(
                    ListItemResponse(1, "text1"),
                    ListItemResponse(2, "text2"),
                    ListItemResponse(3, "text3"),
                )
            )
        )
    }
}