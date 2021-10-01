package com.example.api.domain.repository

import com.example.api.domain.model.entity.Hashtag

interface HashtagRepository {
    fun fetchHashtagById(id: Long): Hashtag?
}