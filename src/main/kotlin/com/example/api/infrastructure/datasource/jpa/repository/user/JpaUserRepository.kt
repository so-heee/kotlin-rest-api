package com.example.api.infrastructure.datasource.jpa.repository.user

import com.example.api.infrastructure.datasource.jpa.entity.JpaUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : JpaRepository<JpaUser, Long>