package com.example.presentation.models

data class PostResponse<Post>(
    val statusCode: Int,
    val data: List<Post?>,
    val errorMessage: String?
) {
    companion object {
        fun mapDomainToPresentation(domainPostResponse: com.example.domain.models.PostResponse<com.example.domain.models.Post>)
                : PostResponse<Post> {
            val list = mutableListOf<Post>()
            domainPostResponse.data.forEach { list.add(Post.mapToPresentation(it!!)) }

            return PostResponse(
                statusCode = domainPostResponse.statusCode,
                data = list,
                errorMessage = domainPostResponse.errorMessage,
            )
        }
    }
}
