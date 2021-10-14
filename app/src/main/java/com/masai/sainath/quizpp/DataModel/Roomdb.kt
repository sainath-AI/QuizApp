package com.masai.sainath.quizpp.DataModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [QuizEntity::class],version = 1)

abstract class Roomdb : RoomDatabase(){
    abstract fun getQuizDao(): QuizDao

    companion object{
        private var INSTANCE: Roomdb?=null
        fun getDatabase(context: Context): Roomdb{
            if(INSTANCE == null){

                val builder = Room.databaseBuilder(
                    context.applicationContext,Roomdb::class.java,
                    "quiz_db")

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                return INSTANCE!!
            }else{

                return INSTANCE!!
            }
        }
    }

}