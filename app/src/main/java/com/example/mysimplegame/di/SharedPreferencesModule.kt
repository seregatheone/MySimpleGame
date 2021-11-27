package com.example.mysimplegame.di

import android.content.SharedPreferences

import android.app.Application
import android.content.Context
import androidx.annotation.Nullable
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class SharedPreferencesModule {

    @[Provides Settings AppScope]
    fun provideSharedPreferencesSettings(application: Application): SharedPreferences {
        return when (val state = application.getSharedPreferences("settings", Context.MODE_PRIVATE)) {
            null -> {
                val editor = state?.edit()
                editor!!.putBoolean("settings", true)
                editor.apply()
                return application.getSharedPreferences("settings", Context.MODE_PRIVATE)
            }
            else -> state
        }

    }

    @[Provides Stats AppScope]
    fun provideSharedPreferencesStats(application: Application): SharedPreferences {
        return when (val state = application.getSharedPreferences("stats", Context.MODE_PRIVATE)) {
            null -> {
                val editor = state?.edit()
                editor!!.putInt("stats", 0)
                editor.apply()
                return application.getSharedPreferences("stats", Context.MODE_PRIVATE)
            }
            else -> state
        }
    }

    @Qualifier
    annotation class Settings

    @Qualifier
    annotation class Stats
}