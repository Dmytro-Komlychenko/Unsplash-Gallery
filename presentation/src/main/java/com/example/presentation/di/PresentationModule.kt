package com.example.presentation.di

import com.example.domain.usecases.GetPostsUseCase
import com.example.presentation.screens.imagelist.PostListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideNoteViewModelFactory(
        getPostsUseCase: GetPostsUseCase,
    ): PostListViewModelFactory {
        return PostListViewModelFactory(
            getPostsUseCase = getPostsUseCase,
        )
    }
}