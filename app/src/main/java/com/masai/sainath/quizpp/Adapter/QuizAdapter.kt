package com.masai.myjournalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.quizpp.MainActivity
import com.masai.sainath.quizpp.R

class QuizAdapter(
    val context: Context,
    val quizList: MutableList<String>,
    val listener: MainActivity
) : RecyclerView.Adapter<QuizAdapter.RoutineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.itemlayout, parent, false)
        return RoutineViewHolder(view1)

    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val task = quizList.get(position)
        //holder.title.text = task.title
        //holder.desc.text = task.desc

        /*holder.editTv.setOnClickListener {
            listener.onEditClicked(task)
        }

        holder.delete.setOnClickListener {
            listener.onDeleteClicked(task)
        }*/

    }

    override fun getItemCount(): Int {
        return quizList.size
    }


    class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var Q1: TextView
        var optionA: TextView
        var optionB: TextView
        var optionC: TextView
        var optionD: TextView

        init {
            Q1 = itemView.findViewById(R.id.question)
            optionA = itemView.findViewById(R.id.optiona)
            optionB = itemView.findViewById(R.id.optionb)
            optionC= itemView.findViewById(R.id.optionc)
            optionD = itemView.findViewById(R.id.optiond)
        }
    }
}