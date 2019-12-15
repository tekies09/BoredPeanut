package com.moontek.peanuts

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_real_main.*
import org.jetbrains.anko.toast

class RealMainActivity : AppCompatActivity() {
    var lastTimeBackPressed:Long =0
    var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        var anim2 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        var firebaseAuth = FirebaseAuth.getInstance()
        val user=firebaseAuth.currentUser
        var Myemail =user!!.email
        Myemail=Myemail.toString().substringBefore("@")
        txtWhoami.setText(Myemail+"님 환영합니다")
        var supportManager = supportFragmentManager

        imgHome1.setBackgroundColor(Color.rgb(255,224,155))
        supportManager.beginTransaction()
            .replace(R.id.fContainer,MainFragment())
            .commit()

        imgIcon4.setOnClickListener { view->
            imgIcon4.startAnimation(anim2)
        }
        btnLogout.setOnClickListener { view ->
            firebaseAuth.signOut()
            toast("로그아웃되었습니다")
            finish()
            startActivity(Intent(this,MainActivity::class.java))
        }
        imgChat1.setOnClickListener { view ->
                supportManager.beginTransaction()
                    .replace(R.id.fContainer,ChatFragment())
                    .commit()
            imgChat1.setBackgroundColor(Color.rgb(255,224,155))
            imgHome1.setBackgroundColor(Color.WHITE)
            imgInternet1.setBackgroundColor(Color.WHITE)
            imgonlypeanut1.setBackgroundColor(Color.WHITE)

        }
        imgHome1.setOnClickListener { view ->
            supportManager.beginTransaction()
                .replace(R.id.fContainer,MainFragment())
                .commit()
            imgHome1.setBackgroundColor(Color.rgb(255,224,155))
            imgChat1.setBackgroundColor(Color.WHITE)
            imgInternet1.setBackgroundColor(Color.WHITE)
            imgonlypeanut1.setBackgroundColor(Color.WHITE)
        }
        imgInternet1.setOnClickListener { view ->
            supportManager.beginTransaction()
                .replace(R.id.fContainer,InternetFragment())
                .commit()
            imgInternet1.setBackgroundColor(Color.rgb(255,224,155))
            imgHome1.setBackgroundColor(Color.WHITE)
            imgChat1.setBackgroundColor(Color.WHITE)
            imgonlypeanut1.setBackgroundColor(Color.WHITE)

        }
        imgonlypeanut1.setOnClickListener { view ->
            supportManager.beginTransaction()
                .replace(R.id.fContainer,PeanutFragment())
                .commit()
            imgonlypeanut1.setBackgroundColor(Color.rgb(255,224,155))
            imgHome1.setBackgroundColor(Color.WHITE)
            imgInternet1.setBackgroundColor(Color.WHITE)
            imgChat1.setBackgroundColor(Color.WHITE)

        }
    }
    override fun onBackPressed() {
        if(System.currentTimeMillis()-lastTimeBackPressed<1500){
            finish()
            return
        }
        else {
            toast("뒤로한번더눌르면 종료")
            lastTimeBackPressed = System.currentTimeMillis();
        }
    }
}
