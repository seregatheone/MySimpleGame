package com.example.mysimplegame.data

import com.example.mysimplegame.data.database.QuizDao
import kotlinx.coroutines.flow.Flow

class QuizRepository (private val quizDao : QuizDao){

    val readAllData: Flow<List<QuestionClass>> = quizDao.readAllData()

    suspend fun addNewQuestion(question:QuestionClass){
        quizDao.addQuestion(question)
    }

    suspend fun deleteAll(){
        quizDao.deleteAll()
    }
}