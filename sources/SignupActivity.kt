package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signup.*
import org.jetbrains.anko.toast

class SignupActivity : AppCompatActivity() {
    val ref = FirebaseDatabase.getInstance().getReference("test")
    var firebaseAuth:FirebaseAuth ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        firebaseAuth = FirebaseAuth.getInstance()
        var anim1 =AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        imgIcon2.setOnClickListener { view ->
            imgIcon2.startAnimation(anim1)
        }
        btnCancel.setOnClickListener { view ->
            finish()
        }
        btnRealSignup.setOnClickListener { view ->
            if(edtSignEmail.text.toString().equals("")|| edtSignPw.text.toString().equals("")){
                toast("이메일 혹은 비밀번호가 공백입니다.")
            }else{
                firebaseAuth!!.createUserWithEmailAndPassword(edtSignEmail.text.toString(),edtSignPw.text.toString())
                    .addOnCompleteListener(this){
                        if(it.isSuccessful){
                                Toast.makeText(this, "가입성공", Toast.LENGTH_SHORT).show()
                            finish()
                        }else {
                            Toast.makeText(this,"중복된 이메일로 인한 가입실패입니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }



    }
}