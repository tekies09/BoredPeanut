package com.moontek.peanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_email_check.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signup.*
import org.jetbrains.anko.toast

class EmailCheckActivity : AppCompatActivity() {
    var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_check)

        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var user=firebaseAuth.currentUser
         var userEmail =user!!.email
        imgIcon3.setOnClickListener { view ->
            imgIcon3.startAnimation(anim1)
        }
        btnCancel2.setOnClickListener { view ->
            finish()
        }
        btnMailSend.setOnClickListener { view ->
            firebaseAuth!!.currentUser!!.sendEmailVerification()
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        toast("메일이 전송됨")
                        txtResult.setText("이메일 : "+userEmail + "\n 메일이 전송되었습니다 확인해주세요.")
                    }else {
                        toast("메일이 전송되지 않았습니다.")
                        txtResult.setText("메일이 전송되지 않았습니다 . \n 잠시후 다시시도 혹은 일일 메일 인증횟수를 초과로인한 실패로 다른계정을 이용해주세요.")
                    }
                }
        }
        btnChecking.setOnClickListener { view ->
            firebaseAuth = FirebaseAuth.getInstance()
            user.reload()
            if(user.isEmailVerified){
                toast("인증완료 메인으로 이동합니다.")
                val intent = Intent(this,RealMainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                startActivity(intent)
                finish()
            }
            else {
                txtResult.setText("현재 인증이 되지 않았습니다. \n 메일 다시확인 혹은 잠시후에 다시 완료버튼을 눌러주세요. \n 메일이 안왔을경우 전송하기버튼을 눌러주세요.")
                toast("인증이 완료되지 않았습니다.")
            }
        }
    }
}
