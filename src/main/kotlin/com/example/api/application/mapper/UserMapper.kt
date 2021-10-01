package com.example.api.application.mapper

import com.example.api.domain.model.entity.User
import com.example.api.openapi.model.UserDto


fun User.toDomainEntity(): UserDto {
    return UserDto().userId(id.toString()).userName(name)
}