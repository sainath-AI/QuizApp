package com.masai.sainath.quizpp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.myjournalapp.adapter.QuizAdapter
import com.masai.sainath.quizpp.Database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val quizList: MutableList<String> = mutableListOf()
    lateinit var mAdapter: QuizAdapter
    lateinit var dbHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        quizList.add("hello")
//        quizList.add("hello")
//        quizList.add("hello")
//        quizList.add("hello")

        mAdapter = QuizAdapter(this, quizList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter

        dbHandler = DatabaseHandler(this)

        createbtn.setOnClickListener {
            dbHandler.insertRoutine("How Many states does india have", "32", "33","29","22")
        }

        updatebtn.setOnClickListener {
            dbHandler.updateRoutine(1, "How Many district does karnataka have", "30", "33","29","22")
        }

        deletebtn.setOnClickListener {
            dbHandler.deleteRoutine(2)
        }
    }

}
