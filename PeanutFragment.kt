package com.moontek.peanuts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_peanut.*

class PeanutFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_peanut, null)
        // 처리
        var imgBrain = view.findViewById<ImageView>(R.id.imgbrain)
        var imgFood = view.findViewById<ImageView>(R.id.imgfood)
        var imgUpdown = view.findViewById<ImageView>(R.id.imgupdown)
        var imgQuestion = view.findViewById<ImageView>(R.id.imgquestion)
        var imgLamp = view.findViewById<ImageView>(R.id.imglamp)
        var imgDiary = view.findViewById<ImageView>(R.id.imgdiary)
        imgBrain.setOnClickListener { view ->
            val intent = Intent(view.context,BrainActivity::class.java)
            startActivity(intent)
        }
        imgFood.setOnClickListener { view ->
            val intent = Intent(view.context,FoodActivity::class.java)
            startActivity(intent)
        }
        imgUpdown.setOnClickListener { view ->
            val intent = Intent(view.context,UpdownActivity::class.java)
            startActivity(intent)
        }
        imgQuestion.setOnClickListener { view ->
            val intent = Intent(view.context,QuestionActivity::class.java)
            startActivity(intent)
        }
        imgLamp.setOnClickListener { view ->
            val intent = Intent(view.context,LampActivity::class.java)
            startActivity(intent)
        }
        imgDiary.setOnClickListener { view ->
            val intent = Intent(view.context,DiaryActivity::class.java)
            startActivity(intent)


        }

        return view
    }
}