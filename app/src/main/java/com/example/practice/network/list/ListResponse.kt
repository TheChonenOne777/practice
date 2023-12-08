package com.example.practice.network.list

import com.example.practice.entity.MockItem

// TODO: replace this with real api model
class ListItemResponse(
    val id: Long,
    val text: String?
) {
    fun toEntity() = MockItem(id, text.orEmpty())
}

class ListResponse(val data: List<ListItemResponse>)
