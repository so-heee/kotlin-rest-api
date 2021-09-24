package com.example.api.infrastructure.datasource.jpa.entity

import com.example.api.domain.model.entity.Hashtag
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "hashtags")
data class JpaHashtag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val tag: String = "",
) {
    fun toDomainEntity(): Hashtag = Hashtag(
        id = id,
        tag = tag
    )
}