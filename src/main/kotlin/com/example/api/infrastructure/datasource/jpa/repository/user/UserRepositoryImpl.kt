package com.example.api.infrastructure.datasource.jpa.repository.user

import com.example.api.domain.model.entity.User
import com.example.api.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl(private val jpaUserRepository: JpaUserRepository) :
    UserRepository {
    override fun fetchUserById(id: Long): User? {
        return jpaUserRepository.findById(id).orElse(null)?.toDomainEntity()
    }
}