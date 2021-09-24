package com.example.api.presentation.controller

import com.example.api.openapi.api.UsersApi
import com.example.api.openapi.model.User
import com.example.api.openapi.model.Users
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController : UsersApi {

    override fun getUsers(): ResponseEntity<Users> {
        TODO("Not yet implemented")
    }

    override fun getUserByID(userId: String): ResponseEntity<User> {
        TODO("Not yet implemented")
    }

    override fun createUsers(): ResponseEntity<User> {
        TODO("Not yet implemented")
    }
}