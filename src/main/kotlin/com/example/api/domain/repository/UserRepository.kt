package com.example.api.domain.repository

import com.example.api.domain.model.entity.User

interface UserRepository {
    fun fetchUserById(id: Long): User?
}