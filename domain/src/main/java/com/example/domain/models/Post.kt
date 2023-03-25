package com.example.domain.models

data class Post(
    val id: Int,
    val authorName: String,
    val description: String?,
    val image_url: String
)