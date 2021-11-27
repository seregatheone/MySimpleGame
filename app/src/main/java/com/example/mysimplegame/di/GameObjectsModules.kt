package com.example.mysimplegame.di

import com.example.mysimplegame.fragments.gamedetails.game.MyTimer
import dagger.Module
import dagger.Provides

@Module
class GameObjectsModules {
    @Provides
    fun timerProvider():MyTimer{
        return MyTimer(30)
    }
}