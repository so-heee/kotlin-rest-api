package com.example.api.application.dto.response

import com.example.api.domain.model.entity.Hashtag

data class HashtagModel(
    var id: Long,
    var tag: String
)

fun Hashtag.toModel() = HashtagModel(
    id, tag
)