package com.example.domain.repositoriesI

import com.example.domain.models.Post
import com.example.domain.models.PostResponse

interface PostRepositoryI {
    suspend fun getPosts(): PostResponse<Post>
}