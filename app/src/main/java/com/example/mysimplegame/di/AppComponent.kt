package com.example.mysimplegame.di

import android.app.Application
import android.content.Context
import com.example.mysimplegame.ProjectApp
import com.example.mysimplegame.data.QuizRepository
import com.example.mysimplegame.data.database.QuizDao
import com.example.mysimplegame.data.database.QuizDatabase
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Scope


@[AppScope Component(modules = [AppModule::class,AndroidInjectionModule::class])]
interface AppComponent:AndroidInjector<ProjectApp>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}

@Module(includes = [SharedPreferencesModule::class, ServicesModule::class,
    FragmentBuilderModule::class , ActivityBuilderModule::class,DBModule::class])
class AppModule

@Module
class DBModule{
    @Provides
    fun repositoryProvider (quizDao:QuizDao): QuizRepository= QuizRepository(quizDao)

    @Provides
    fun provideQuizDao(application: Application) :QuizDao= QuizDatabase.getDatabase(application).quizDao()
}
@Scope
annotation class AppScope