package com.example.mysimplegame.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "quiz_table")
data class QuestionClass (
    @PrimaryKey
    val id:Int,
    val question:String,
    val answerFirst:String,
    val answerSecond:String,
    val answerThird:String,
    val answerFourth:String,
    val correctAnswer:Int):Parcelable

