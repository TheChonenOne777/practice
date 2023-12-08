package com.example.practice.features.list

import com.example.practice.base.ResultModel
import com.example.practice.entity.MockItem
import javax.inject.Inject

class ListInteractor @Inject constructor(private val repo: ListRepo) {

    suspend fun getListOfItems(): ResultModel<List<MockItem>> = repo.requestNewList()
}