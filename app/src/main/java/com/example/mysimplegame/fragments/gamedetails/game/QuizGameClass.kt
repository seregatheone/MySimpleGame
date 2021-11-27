package com.example.mysimplegame.fragments.gamedetails.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mysimplegame.R
import com.example.mysimplegame.fragments.gamedetails.gamefragment.GameFragment
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.onEach


class QuizGameClass : DaggerFragment(R.layout.quiz_layout){

    private var _timerView:TextView? = null
    private val timerView get() = _timerView!!

    private val viewModel:QuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _timerView = activity!!.findViewById(R.id.timer)
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,GameFragment())
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenStarted {
            viewModel.currentTime
                .onEach { time ->
                    timerView.text = time.toString()
                }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}