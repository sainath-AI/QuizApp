package com.masai.sainath.quizpp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.quizpp.DataModel.QuizEntity
import com.masai.sainath.quizpp.R

class QuizAdapter(private val dataHolder: MutableList<QuizEntity>,val listner : OnItemClicked) : RecyclerView.Adapter<QuizViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)

        return QuizViewHolder(view,listner)

    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        var model = dataHolder[position]

        holder.setData(model)

    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }
}