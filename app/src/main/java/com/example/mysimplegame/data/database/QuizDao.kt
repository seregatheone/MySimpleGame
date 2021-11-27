package com.example.mysimplegame.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mysimplegame.data.QuestionClass
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addQuestion(question : QuestionClass)

    @Query("SELECT * FROM quiz_table ORDER by id ASC")
    fun readAllData(): Flow<List<QuestionClass>>

    @Query("DELETE FROM quiz_table")
    suspend fun deleteAll()
}