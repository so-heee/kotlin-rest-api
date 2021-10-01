package com.example.api.infrastructure.datasource.jpa.repository.hashtag

import com.example.api.domain.model.entity.Hashtag
import com.example.api.domain.repository.HashtagRepository
import org.springframework.stereotype.Component

@Component
class HashtagRepositoryImpl(private val jpaHashtagRepository: JpaHashtagRepository) :
    HashtagRepository {
    override fun fetchHashtagById(id: Long): Hashtag? {
        return jpaHashtagRepository.findById(id).orElse(null)?.toDomainEntity()
    }
}