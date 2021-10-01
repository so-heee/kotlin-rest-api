package com.example.api.application.service

import com.example.api.application.dto.response.HashtagModel
import org.springframework.http.ResponseEntity

interface HashtagApplicationService {

    /**
     * 取得
     * @param id
     * @return ResponseEntity<HashtagModel>
     */
    fun getHashtag(id: Long): ResponseEntity<HashtagModel>
}