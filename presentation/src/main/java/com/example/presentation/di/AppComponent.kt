package com.example.presentation.di

import com.example.presentation.screens.imagelist.PostListFragment
import dagger.Component

@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: PostListFragment)
}