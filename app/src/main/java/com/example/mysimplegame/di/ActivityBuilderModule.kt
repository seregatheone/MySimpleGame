package com.example.mysimplegame.di

import com.example.mysimplegame.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}