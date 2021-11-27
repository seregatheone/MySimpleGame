package com.example.mysimplegame.fragments.gamedetails.game

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.mysimplegame.data.QuizRepository
import com.example.mysimplegame.di.SharedPreferencesModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuizViewModel @Inject constructor (private val quizRepository: QuizRepository): ViewModel() {
    @Inject
    lateinit var timer:MyTimer

    @[Inject SharedPreferencesModule.Stats]
    lateinit var sharedPreferencesStats: SharedPreferences

    val currentTime: MutableStateFlow<Long> = MutableStateFlow(0)

    private val bestScore:Int by lazy{
        sharedPreferencesStats.getInt(
            "stats",0
        )
    }

    private val score:Int = 0

    private fun startGame(){
        CoroutineScope(Dispatchers.IO).launch {
            timer.startTimer()
            timer.milliSeconds.onEach {value->
                currentTime.value = value
            }
        }.invokeOnCompletion {
            endGame()
        }
    }
    private fun endGame(){
        if (score>bestScore){
            val editor = sharedPreferencesStats.edit()
            editor.putInt("stats",score)
            editor.apply()
        }
    }
}