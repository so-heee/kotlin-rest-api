package com.example.api.application.service

import com.example.api.application.dto.response.UserModel
import org.springframework.http.ResponseEntity

interface UserApplicationService {

    /**
     * ユーザーの取得
     * @param id
     * @return ResponseEntity<UserModel>
     */
    fun getUser(id: Long): ResponseEntity<UserModel>
}