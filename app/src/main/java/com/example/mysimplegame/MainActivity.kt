package com.example.mysimplegame

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ToggleButton
import com.example.mysimplegame.di.SharedPreferencesModule
import com.example.mysimplegame.services.BackgroundSoundService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    @SharedPreferencesModule.Settings
    lateinit var sharedPreferences: SharedPreferences

    private var toggleButton: ToggleButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toggle button
        toggleButton = findViewById(R.id.musicToggleButton)
        toggleButton!!.setOnCheckedChangeListener { compoundButton, _ ->
            val state = compoundButton.isChecked
            saveSharedPreferences(sharedPreferences,state)
            when (state) {
                true -> startService(Intent(this, BackgroundSoundService::class.java))
                else -> stopService(Intent(this, BackgroundSoundService::class.java))
            }
        }
        toggleButton!!.isChecked = loadSharedPreferences(sharedPreferences)

    }
    private fun loadSharedPreferences(sharedPreferences: SharedPreferences):Boolean = sharedPreferences.getBoolean("settings", true)
    private fun saveSharedPreferences(sharedPreferences: SharedPreferences,value:Boolean){
        val editor = sharedPreferences.edit()
        editor.putBoolean("settings", value)
        editor.apply()
    }
}