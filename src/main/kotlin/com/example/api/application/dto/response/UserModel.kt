package com.example.api.application.dto.response

import com.example.api.domain.model.entity.User

data class UserModel(
    var id: Long,
    var name: String
)

fun User.toModel() = UserModel(
    id, name
)