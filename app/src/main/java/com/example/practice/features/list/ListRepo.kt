package com.example.practice.features.list

import com.example.practice.base.ResultModel
import com.example.practice.base.asResult
import com.example.practice.entity.MockItem
import com.example.practice.network.NetworkResult
import com.example.practice.network.list.RemoteListDataSource
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ListRepo @Inject constructor(private val remoteDataSource: RemoteListDataSource) {

    suspend fun requestNewList(): ResultModel<List<MockItem>> {
        return when (val result = remoteDataSource.requestList()) {
            is NetworkResult.Success -> result.data.data.map { it.toEntity() }.asResult()
            // TODO: add error handling
            else -> ResultModel.Error(IllegalArgumentException())
        }

    }
}