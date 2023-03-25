package com.example.presentation.app

import android.app.Application
import com.example.presentation.di.AppComponent
import com.example.presentation.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}
