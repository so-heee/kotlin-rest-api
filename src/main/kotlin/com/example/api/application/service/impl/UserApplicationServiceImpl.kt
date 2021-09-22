package com.example.api.application.service.impl

import com.example.api.application.dto.response.UserModel
import com.example.api.application.dto.response.toModel
import com.example.api.application.service.UserApplicationService
import com.example.api.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserApplicationServiceImpl(val userRepository: UserRepository) : UserApplicationService {

    override fun getUser(id: Long): ResponseEntity<UserModel> {
        return userRepository.fetchUserById(id)
            .let { ResponseEntity.ok(it?.toModel()) }
    }
}