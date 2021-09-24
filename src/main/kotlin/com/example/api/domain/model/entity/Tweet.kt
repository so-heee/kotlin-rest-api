package com.example.api.domain.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "tweets")
data class Tweet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val text: String = "",
)