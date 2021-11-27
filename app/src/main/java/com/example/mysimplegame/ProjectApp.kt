package com.example.mysimplegame

import com.example.mysimplegame.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ProjectApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}