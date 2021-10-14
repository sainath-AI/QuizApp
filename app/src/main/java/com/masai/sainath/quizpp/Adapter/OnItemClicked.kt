package com.masai.sainath.quizpp.Adapter

import com.masai.sainath.quizpp.DataModel.QuizEntity

interface OnItemClicked {

    fun onEditButtonClicked(quizEntity: QuizEntity)
    fun onDeleteButtonClicked(quizEntity: QuizEntity)
}