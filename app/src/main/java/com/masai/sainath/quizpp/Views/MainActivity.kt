package com.masai.sainath.quizpp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sainath.quizpp.Adapter.OnItemClicked
import com.masai.sainath.quizpp.Adapter.QuizAdapter
import com.masai.sainath.quizpp.DataModel.QuizDao
import com.masai.sainath.quizpp.DataModel.QuizEntity
import com.masai.sainath.quizpp.DataModel.Roomdb
import com.masai.sainath.quizpp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), OnItemClicked{

    val listOfQuiz= mutableListOf<QuizEntity>()
    lateinit var qadapter: QuizAdapter

    lateinit var roomdb: Roomdb
    lateinit var quizDao: QuizDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fbAdd.setOnClickListener {
            var intent=Intent(this,CreateQuiz::class.java)
            startActivity(intent)
        }
        roomdb= Roomdb.getDatabase(this)
        quizDao=roomdb.getQuizDao()

        qadapter= QuizAdapter(listOfQuiz,this)
        rvRecycler.layoutManager=LinearLayoutManager(this)
        rvRecycler.adapter=qadapter

        quizDao.getQuiz().observe(this, Observer {
            val data=it
            listOfQuiz.clear()
            listOfQuiz.addAll(data)
            qadapter.notifyDataSetChanged()

        })


    }

    override fun onEditButtonClicked(quizEntity: QuizEntity) {
        var intents = Intent(this,CreateQuiz::class.java)
        Toast.makeText(this,"Long Press to Edit Title,Type,Amount", Toast.LENGTH_LONG).show()
        startActivity(intents)
        var bundle = intent.extras

        var editQuestion = bundle?.getString("question")
        var editOptionA = bundle?.getString("optiona")
        var editOptionB = bundle?.getInt("optionb")
        var editOptionC = bundle?.getInt("optionc")
        var editOptionD = bundle?.getInt("optiond")

        quizEntity.Question = editQuestion.toString()
        quizEntity.OptionA = editOptionA.toString()
        quizEntity.OptionB = editOptionB.toString()
        quizEntity.OptionC = editOptionC.toString()
        quizEntity.OptionD= editOptionD.toString()

        CoroutineScope(Dispatchers.IO).launch{
            quizDao.Update(quizEntity)
        }
    }

    override fun onDeleteButtonClicked(quizEntity: QuizEntity) {
        CoroutineScope(Dispatchers.IO).launch{
            quizDao.Delete(quizEntity)
        }    }
}