package com.example.domain.models

data class PostResponse<T>(
    val statusCode: Int,
    val data: List<T?>,
    val errorMessage: String?
)
