package com.example.api.application.service.impl

import com.example.api.application.dto.response.HashtagModel
import com.example.api.application.dto.response.toModel
import com.example.api.application.service.HashtagApplicationService
import com.example.api.domain.repository.HashtagRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class HashtagApplicationServiceImpl(val hashtagRepository: HashtagRepository) :
    HashtagApplicationService {

    override fun getUser(id: Long): ResponseEntity<HashtagModel> {
        return hashtagRepository.fetchUserById(id)
            .let { ResponseEntity.ok(it?.toModel()) }
    }
}