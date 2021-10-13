package com.masai.sainath.quizpp.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


class DatabaseHandler(val context: Context) :
        SQLiteOpenHelper(context, "Quizdb", null, 1) {

        companion object {
            val TABLE_NAME = "Quiz_Table"
            val ID = "id"
            val Question = "question"
            val OptionA = "optiona"
            val OptionB = "optionb"
            val OptionC = "optionc"
            val OptionD = "optionb"
        }

        override fun onCreate(db: SQLiteDatabase?) {
            val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                    "$Question TEXT, $OptionA TEXT, $OptionB TEXT,$OptionC TEXT,$OptionD TEXT)"
            db?.execSQL(createQuery)
        }

        fun insertRoutine(question: String, optiona: String,optionb: String,optionc: String,optiond: String ) {
            val db = writableDatabase
            val values = ContentValues()
            values.put(Question, question)
            values.put(OptionA, optiona)
            values.put(OptionB, optionb)
            values.put(OptionC, optionc)
            values.put(OptionD, optiond)

            val id = db.insert(TABLE_NAME, null, values)
            if (id.toInt() == -1) {
                //Error
                Toast.makeText(context, "Error: Data is not inserted", Toast.LENGTH_SHORT).show()
            } else {
                //Success
                Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show()
            }
        }

        fun updateRoutine(id: Int, Newquestion: String, Newoptiona: String,Newoptionb: String,Newoptionc: String,Newoptiond: String ) {
            val db = writableDatabase
            val values = ContentValues()
            values.put(ID, id)
            values.put(Question, Newquestion)
            values.put(OptionA, Newoptiona)
            values.put(OptionB, Newoptionb)
            values.put(OptionC, Newoptionc)
            values.put(OptionD, Newoptiond)

            val affectedRows = db.update(TABLE_NAME, values, "id = $id", null)
            if (affectedRows > 0) {
                //Success
                Toast.makeText(context, "Data updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                //Failure
                Toast.makeText(context, "Error: Data is not updated", Toast.LENGTH_SHORT).show()
            }
        }

        fun deleteRoutine(id: Int) {
            val db = writableDatabase
            val affectedRows = db.delete(TABLE_NAME, "id = $id", null)
            if (affectedRows > 0) {
                //Success
                Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_SHORT).show()
            } else {
                //Failure
                Toast.makeText(context, "Error: Data is not deleted", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

    }
