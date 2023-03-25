package com.example.presentation.models

data class Post(
    val id: Int,
    val authorName: String,
    val description: String?,
    val image_url: String
) {
    companion object {
        fun mapToPresentation(domainPost: com.example.domain.models.Post): Post {
            return Post(
                id = domainPost.id,
                authorName = domainPost.authorName,
                description = domainPost.description,
                image_url = domainPost.image_url,
            )
        }
    }

}