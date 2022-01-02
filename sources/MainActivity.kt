package com.moontek.peanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    var lastTimeBackPressed:Long =0
    val ref = FirebaseDatabase.getInstance().getReference("test")
    var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadData()
        firebaseAuth = FirebaseAuth.getInstance()
        var anim2 =AnimationUtils.loadAnimation(applicationContext,R.anim.scale1_anim)
        var anim1 =AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 =AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        txtMain.startAnimation(anim2)
        txtMain.setOnClickListener{view ->
            txtMain.startAnimation(anim3)
        }
        imgIcon.setOnClickListener { view ->
            imgIcon.startAnimation(anim1)
                }
        btnSignup.setOnClickListener { view ->
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener { view ->
            if(edtEmail.text.toString().equals("") || edtPw.text.toString().equals("")){
                Toast.makeText(this,"이메일 혹은 패스워드 공백", Toast.LENGTH_SHORT).show()
            }else {
                firebaseAuth!!.signInWithEmailAndPassword(edtEmail.text.toString().trim(),edtPw.text.toString().trim())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            var isChecked = chAuto.isChecked
                                SaveData(edtEmail.text.toString(),edtPw.text.toString(),isChecked)
                            toast("로그인 성공")
                            if(FirebaseAuth.getInstance().currentUser!!.isEmailVerified){
                                toast("인증됨")
                                startActivity(Intent(this,RealMainActivity::class.java))
                                finish()
                            }
                            else {
                                toast("인증안된계정")
                                startActivity(Intent(this,EmailCheckActivity::class.java))
                            }

                        }else {
                            toast("로그인 실패")
                        }
                    }
            }
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
    fun SaveData(Email :String,Pw : String,ischAutochecked:Boolean){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor =pref.edit()

        editor.putString("KEY_EMAIL",Email)
        editor.putString("KEY_PW",Pw)
        editor.putBoolean("KEY_CHECK",ischAutochecked)
        editor.apply()
    }
    fun LoadData(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val Email = pref.getString("KEY_EMAIL",null)
        val Pw = pref.getString("KEY_PW",null)
        val Check =  pref.getBoolean("KEY_CHECK",false)

        if(Check==true){
            edtEmail.setText(Email.toString())
            edtPw.setText(Pw.toString())
            chAuto.setChecked(true)
        }
    }
}
