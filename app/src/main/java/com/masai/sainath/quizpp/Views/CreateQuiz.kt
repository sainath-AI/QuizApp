package com.masai.sainath.quizpp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.masai.sainath.quizpp.DataModel.QuizDao
import com.masai.sainath.quizpp.DataModel.QuizEntity
import com.masai.sainath.quizpp.DataModel.Roomdb
import com.masai.sainath.quizpp.R
import kotlinx.android.synthetic.main.activity_create_quiz.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateQuiz : AppCompatActivity() {

    lateinit var roomDb : Roomdb
    lateinit var quizDao: QuizDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quiz)

        roomDb = Roomdb.getDatabase(this)
        quizDao= roomDb.getQuizDao()

        btnAdd.setOnClickListener {
            val question=etquestion.text.toString()
            val optiona=optionA.text.toString()
            val optionb=optionB.text.toString()
            val optionc=optionC.text.toString()
            val optiond=optionD.text.toString()

            val quizEntity=QuizEntity(question,optiona,optionb,optionc,optiond)

            CoroutineScope(Dispatchers.IO).launch {
                quizDao.createQuiz(quizEntity)
            }
            if(isCredentialValid()){
                var intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        }

        etquestion.setOnLongClickListener {
            editquestion.visibility= View.VISIBLE
            true
        }
            optionA.setOnLongClickListener {
            editOptionA.visibility= View.VISIBLE
            true
        }
        optionB.setOnLongClickListener {
            editoptionB.visibility= View.VISIBLE
            true
        }
        optionC.setOnLongClickListener {
            editOPtionc.visibility= View.VISIBLE
            true
        }
        optionD.setOnLongClickListener {
            editOptionD.visibility= View.VISIBLE
            true
        }
        btnAdd.setOnLongClickListener {

            var intent   = Intent(this, MainActivity::class.java)

            intent.putExtra("question",etquestion.text.toString())
            intent.putExtra("optiona",editOptionA.text.toString())
            intent.putExtra("optionb",editoptionB.text.toString())
            intent.putExtra("optionc",editOPtionc.text.toString())
            intent.putExtra("optiond",editOptionD.text.toString())
            Toast.makeText(this,"Press Update To Refresh List", Toast.LENGTH_LONG).show()
            startActivity(intent)
            true
        }
    }

    private fun isCredentialValid(): Boolean {

        var isDataValid = true
        if (etquestion.text.toString().isEmpty()) {
            etquestion.error=" question can't be empty"
            isDataValid = false
        }

        if (optionA.text.toString().isEmpty()) {
            optionA.error = "this field can't be Empty"
            isDataValid = false

        }

        if (optionB.text.toString().isEmpty()) {
            optionB.error="This field can't be Empty"
            isDataValid = false

        }
        if (optionC.text.toString().isEmpty()) {
            optionC.error="This field can't be Empty"
            isDataValid = false
        }
        if (optionD.text.toString().isEmpty()) {
            optionD.error="This field can't be Empty"
            isDataValid = false
        }

        return isDataValid

    }
}