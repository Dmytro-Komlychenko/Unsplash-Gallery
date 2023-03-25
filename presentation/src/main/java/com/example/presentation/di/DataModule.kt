package com.example.presentation.di

import com.example.data.repositories.PostRepository
import com.example.domain.repositoriesI.PostRepositoryI
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideImageListViewModelFactory(): PostRepositoryI {
        return PostRepository()
    }
}