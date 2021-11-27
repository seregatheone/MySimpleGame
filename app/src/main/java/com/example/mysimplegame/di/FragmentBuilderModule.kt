package com.example.mysimplegame.di


import com.example.mysimplegame.fragments.gamedetails.gamefragment.GameFragment
import com.example.mysimplegame.fragments.StartFragment
import com.example.mysimplegame.fragments.gamedetails.game.QuizGameClass
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun bindStartFragment(): StartFragment

    @ContributesAndroidInjector
    abstract fun bindGameFragment(): GameFragment

    @ContributesAndroidInjector
    abstract fun bindQuizGameFragment(): QuizGameClass
}