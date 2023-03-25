package com.example.presentation.screens.imagelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetPostsUseCase

class PostListViewModelFactory(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostListViewModel(
            getPostsUseCase = getPostsUseCase,
        ) as T
    }

}