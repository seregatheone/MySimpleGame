package com.example.mysimplegame.di

import com.example.mysimplegame.services.BackgroundSoundService
import dagger.Module
import dagger.Provides

@Module
class ServicesModule{
    @[Provides AppScope]
    fun provideBackgroundSoundService(): BackgroundSoundService {
        return BackgroundSoundService()
    }
}
