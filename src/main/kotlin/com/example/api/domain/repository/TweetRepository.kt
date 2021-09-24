package com.example.api.domain.repository

import com.example.api.domain.model.entity.Tweet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository : JpaRepository<Tweet, Long>
