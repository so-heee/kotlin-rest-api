package com.example.api.domain.repository

import com.example.api.domain.model.entity.Hashtag

interface HashtagRepository {
    fun fetchUserById(id: Long): Hashtag?
}