package com.example.api.infrastructure.datasource.jpa.entity

import com.example.api.domain.model.entity.User
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user")
data class JpaUser(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val name: String = "",
) {
    fun toDomainEntity(): User = User(
        id = id,
        name = name
    )
}