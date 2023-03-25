package com.example.domain.usecases

import com.example.domain.models.Post
import com.example.domain.models.PostResponse
import com.example.domain.repositoriesI.PostRepositoryI

class GetPostsUseCase(private val postRepository: PostRepositoryI) {
    suspend fun execute(): PostResponse<Post> {
        return postRepository.getPosts()
    }
}