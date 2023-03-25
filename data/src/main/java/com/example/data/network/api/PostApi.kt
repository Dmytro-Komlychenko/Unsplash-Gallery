package com.example.data.network.api

import com.example.data.network.models.PostEntity
import com.example.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("photos/?client_id=${Constants.USER_KEY}")
    suspend fun getPosts(): Response<List<PostEntity>>

}