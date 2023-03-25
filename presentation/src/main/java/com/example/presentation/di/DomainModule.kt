package com.example.presentation.di

import com.example.domain.repositoriesI.PostRepositoryI
import com.example.domain.usecases.GetPostsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetNoteUseCase(postRepository: PostRepositoryI): GetPostsUseCase{
        return GetPostsUseCase(postRepository = postRepository)
    }

}