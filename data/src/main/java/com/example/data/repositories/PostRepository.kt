package com.example.data.repositories

import com.example.data.network.retrofit.RetrofitInstance
import com.example.domain.models.Post
import com.example.domain.models.PostResponse
import com.example.domain.repositoriesI.PostRepositoryI

class PostRepository : PostRepositoryI {

    override suspend fun getPosts(): PostResponse<Post> {
        return com.example.data.mappers.PostResponse.mapToDomain(RetrofitInstance.api.getPosts())
    }
}
