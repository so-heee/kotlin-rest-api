package com.example.kotlinrestapi.application.repository

import com.example.kotlinrestapi.infrastructure.jpa.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : JpaRepository<Article, Long>