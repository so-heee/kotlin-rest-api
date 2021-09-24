package com.example.api.infrastructure.datasource.jpa.repository.hashtag

import com.example.api.infrastructure.datasource.jpa.entity.JpaHashtag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaHashtagRepository : JpaRepository<JpaHashtag, Long>