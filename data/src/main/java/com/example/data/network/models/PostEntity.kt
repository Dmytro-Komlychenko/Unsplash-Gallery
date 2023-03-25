package com.example.data.network.models

import com.google.gson.annotations.SerializedName

data class PostEntity(
    @SerializedName("alt_description")
    val description: String?,
    @SerializedName("urls")
    val images: Images,
    val user: User
)


data class Images(
    val regular: String
)

data class User(
    val username: String
)

