package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_lamp.*
import kotlinx.android.synthetic.main.fragment_peanut.*
import org.jetbrains.anko.toast

class LampActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lamp)
        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        imgIcon7.setOnClickListener { view ->
            imgIcon7.startAnimation(anim3)
        }
        imgLamp.setOnClickListener { view ->
            imgLamp.startAnimation(anim1)
        }
        btnLampCancel.setOnClickListener { view ->
            toast("소중한 기회를 날리고 돌아가다니 아쉽군")
            finish()
        }
        btnWish.setOnClickListener { view ->
            toast("네 잘들었습니다 ^^;")
            finish()
        }
    }
}
