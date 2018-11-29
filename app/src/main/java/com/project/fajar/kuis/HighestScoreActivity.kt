package com.project.fajar.kuis

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.content.SharedPreferences

class HighestScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highest_score)

        val txtScore = findViewById(R.id.textScore) as TextView
        val txtHighScore = findViewById(R.id.textHighScore) as TextView

        val intent = getIntent()
        val score = intent.getIntExtra("score",0)
        txtScore.setText("Your score : $score")

        val mypref = getPreferences(MODE_PRIVATE)
        val highscore = mypref.getInt("highscore", 0)
        if (highscore >= score)
            txtHighScore.setText("HighScore : $highscore")
        else{
            txtHighScore.setText("New Highscore : $score")
            val editor = mypref.edit()
            editor.putInt("highscore", score)
            editor.commit()
        }
    }
    fun onClick(view: View) {
        val intent = Intent(this@HighestScoreActivity,QuizActivity::class.java)
        startActivity(intent)
    }
}
