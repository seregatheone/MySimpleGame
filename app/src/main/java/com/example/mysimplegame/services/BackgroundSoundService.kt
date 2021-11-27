package com.example.mysimplegame.services

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.mysimplegame.ProjectApp
import com.example.mysimplegame.R
import com.example.mysimplegame.di.AppScope
import javax.inject.Inject

class BackgroundSoundService: Service() {

    private lateinit var mediaPlayer:MediaPlayer

    override fun onCreate() {
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.backgroundmusic)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        super.onCreate()
    }


    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}