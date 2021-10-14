package com.masai.sainath.quizpp.DataModel

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createQuiz(quizEntity: QuizEntity)

    @Query("Select *from quiz_table")
    fun getQuiz(): LiveData<List<QuizEntity>>

    @Update()
    fun Update(quizEntity: QuizEntity)

    @Delete()
    fun Delete(quizEntity: QuizEntity)
}