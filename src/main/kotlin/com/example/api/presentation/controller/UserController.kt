package com.example.api.presentation.controller

import com.example.api.application.dto.response.UserModel
import com.example.api.application.service.UserApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController() {

    @Autowired
    lateinit var userApplicationService: UserApplicationService

    @GetMapping("/users/{id}")
    fun getArticleById(@PathVariable(value = "id") id: Long): ResponseEntity<UserModel> {
        return userApplicationService.getUser(id)
    }
}