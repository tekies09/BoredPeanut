package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        var anim2 = AnimationUtils.loadAnimation(applicationContext,R.anim.scale1_anim)
        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        btnQuestionCancel.setOnClickListener { view ->
            finish()
        }
        imgIcon8.setOnClickListener { view ->
            imgIcon8.startAnimation(anim3)
        }
    }
}
