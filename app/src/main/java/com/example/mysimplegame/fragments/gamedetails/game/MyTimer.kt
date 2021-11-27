package com.example.mysimplegame.fragments.gamedetails.game

import android.os.CountDownTimer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach


class MyTimer(private val time:Long) {
    private var timer = Timer(time*1000)
    val milliSeconds: MutableStateFlow<Long> = MutableStateFlow(0)
    //Call this method to start timer on activity start
    fun startTimer(){

        timer.millisUntilFinished.onEach { value -> milliSeconds.value = value }
        timer.start()
    }

    inner class Timer(milliSeconds:Long) : CountDownTimer(milliSeconds,1000){
        val millisUntilFinished: MutableStateFlow<Long> = MutableStateFlow(0)
        override fun onFinish() {
            this.millisUntilFinished.value = -1
        }

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished.value = millisUntilFinished
        }
    }
}