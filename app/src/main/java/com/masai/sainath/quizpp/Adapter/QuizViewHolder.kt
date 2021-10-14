package com.masai.sainath.quizpp.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.quizpp.DataModel.QuizEntity
import kotlinx.android.synthetic.main.itemlayout.view.*

class QuizViewHolder(itemView: View, val listner : OnItemClicked) : RecyclerView.ViewHolder(itemView) {

    fun setData(quizEntity: QuizEntity){

        itemView.apply {
            question.text="Question : ${quizEntity.Question}"
            optionA.text="Question : ${quizEntity.OptionA}"
            optionB.text="Question : ${quizEntity.OptionB}"
            optionC.text="Question : ${quizEntity.OptionC}"
            optionD.text="Question : ${quizEntity.OptionD}"

            cvCard.setOnClickListener {
                ivDel.visibility=View.VISIBLE
                ivEdit.visibility=View.VISIBLE

                ivEdit.setOnClickListener {
                    listner.onEditButtonClicked(quizEntity)
                }
                ivDel.setOnClickListener {
                    listner.onDeleteButtonClicked(quizEntity)
                }
            }
        }
    }
}