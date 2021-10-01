package com.example.api.application.service

import com.example.api.openapi.model.UserDto
import org.springframework.http.ResponseEntity

interface UserApplicationService {

    /**
     * 取得
     * @param id
     * @return ResponseEntity<User>
     */
    fun getUser(id: Long): ResponseEntity<UserDto>
}