package com.masai.sainath.quizpp.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_table")
data  class QuizEntity (@ColumnInfo(name="question")
                        var Question: String,
                        @ColumnInfo(name = "optionA")
                        var OptionA: String,
                        @ColumnInfo(name = "optionB")
                        var OptionB: String,
                        @ColumnInfo(name = "optionC")
                        var OptionC: String,
                        @ColumnInfo(name = "optionD")
                        var OptionD: String,

                        )
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int?=null
}