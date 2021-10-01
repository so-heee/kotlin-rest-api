package com.example.api.presentation.controller

import com.example.api.application.dto.response.HashtagModel
import com.example.api.application.service.HashtagApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HashtagController() {

    @Autowired
    lateinit var hashtagApplicationService: HashtagApplicationService

    @GetMapping("/hashtags/{id}")
    fun getArticleById(@PathVariable(value = "id") id: Long): ResponseEntity<HashtagModel> {
        return hashtagApplicationService.getHashtag(id)
    }
}