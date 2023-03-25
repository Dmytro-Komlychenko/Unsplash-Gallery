package com.example.presentation.screens.imagelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetPostsUseCase
import com.example.presentation.models.Post
import com.example.presentation.models.PostResponse
import kotlinx.coroutines.launch

class PostListViewModel(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    var posts: MutableLiveData<PostResponse<Post>> = MutableLiveData()

    init {
        viewModelScope.launch {
            posts.value = PostResponse.mapDomainToPresentation(getPostsUseCase.execute())
        }
    }
}