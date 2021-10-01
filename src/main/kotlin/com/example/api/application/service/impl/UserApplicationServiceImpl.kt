package com.example.api.application.service.impl

import com.example.api.application.mapper.toDomainEntity
import com.example.api.application.service.UserApplicationService
import com.example.api.domain.repository.UserRepository
import com.example.api.openapi.model.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserApplicationServiceImpl(val userRepository: UserRepository) :
    UserApplicationService {

    override fun getUser(id: Long): ResponseEntity<UserDto> {
        return userRepository.fetchUserById(id)
            .let { ResponseEntity.ok(it?.toDomainEntity()) }
    }
}