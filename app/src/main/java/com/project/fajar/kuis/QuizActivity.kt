package com.project.fajar.kuis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    private val mQuestionLibrary = QuestionBank()
    private var mScoreView: TextView? = null   // Untuk menampilkan skor saat ini
    private var mQuestionView: TextView? = null  //menampilkan jawaban
    private var mButtonChoice1: Button? = null // jawaban 1
    private var mButtonChoice2: Button? = null // jawaban 2
    private var mButtonChoice3: Button? = null //jawaban 3
    private var mButtonChoice4: Button? = null //jawaban 4

    private var mAnswer: String? = null  // untuk cek jawaban benar atau tidaknya
    private var mScore = 0  // current total score
    private var mQuestionNumber = 0 //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        //
        mScoreView = findViewById(R.id.score) as TextView
        mQuestionView = findViewById(R.id.question) as TextView
        mButtonChoice1 = findViewById(R.id.choice1) as Button
        mButtonChoice2 = findViewById(R.id.choice2) as Button
        mButtonChoice3 = findViewById(R.id.choice3) as Button
        mButtonChoice4 = findViewById(R.id.choice4) as Button
        updateQuestion()

        updateScore(mScore)
    }

    private fun updateQuestion() {
        //
        if (mQuestionNumber < mQuestionLibrary.length) {


            mQuestionView!!.setText(mQuestionLibrary.getQuestion(mQuestionNumber))
            mButtonChoice1!!.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1))
            mButtonChoice2!!.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2))
            mButtonChoice3!!.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3))
            mButtonChoice4!!.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4))
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber)
            mQuestionNumber++
        } else {
            Toast.makeText(this@QuizActivity, "It was the last question!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@QuizActivity, HighestScoreActivity::class.java)
            intent.putExtra("score", mScore) // pass the current score to the second screen
            startActivity(intent)
        }
    }

    private fun updateScore(point: Int) {
        mScoreView!!.setText("" + mScore + "/" + mQuestionLibrary.length)
    }

    fun onClick(view: View) {
        //all logic for all answers buttons in one method
        val answer = view as Button
        // if the answer is correct, increase the score
        if (answer.getText() === mAnswer) {
            mScore = mScore + 1
            Toast.makeText(this@QuizActivity, "Benar!", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this@QuizActivity, "Salah!", Toast.LENGTH_SHORT).show()

        updateScore(mScore)
        updateQuestion()
    }
}
