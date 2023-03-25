package com.example.data.mappers

import com.example.data.network.models.PostEntity
import com.example.domain.models.Post
import com.example.domain.models.PostResponse

object PostResponse {

    fun mapToDomain(dataResponse: retrofit2.Response<List<PostEntity>>): PostResponse<Post> {
        val postList = mutableListOf<Post>()


        dataResponse.body()?.forEach {
            postList.add(
                Post(
                    id = postList.lastOrNull()?.id?.plus(1) ?: 0,
                    authorName = it.user.username,
                    description = it.description,
                    image_url = it.images.regular
                )
            )
        }

        return PostResponse(
            statusCode = dataResponse.code(),
            data = postList,
            errorMessage = dataResponse.errorBody().toString(),
        )
    }
}