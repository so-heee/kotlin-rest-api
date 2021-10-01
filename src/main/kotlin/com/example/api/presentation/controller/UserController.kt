package com.example.api.presentation.controller

import com.example.api.application.service.UserApplicationService
import com.example.api.openapi.api.UsersApi
import com.example.api.openapi.model.UserDto
import com.example.api.openapi.model.UsersDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController : UsersApi {

    @Autowired
    lateinit var userApplicationService: UserApplicationService

    override fun getUsers(): ResponseEntity<UsersDto> {
        return ResponseEntity.ok().body(UsersDto())
    }

    override fun getUserByID(userId: String): ResponseEntity<UserDto> {
        return userApplicationService.getUser(userId.toLong())
    }

    override fun createUsers(): ResponseEntity<UserDto> {
        TODO("Not yet implemented")
    }
}