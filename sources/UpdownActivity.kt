package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_updown.*
import kotlinx.android.synthetic.main.fragment_peanut.*
import org.jetbrains.anko.toast
import java.lang.NumberFormatException
import java.util.*

class UpdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updown)
        var anim2 = AnimationUtils.loadAnimation(applicationContext,R.anim.scale1_anim)
        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        val random = Random()
        var num = random.nextInt(101)
        var usernum=0
        var count = 6
        imgIcon9.setOnClickListener { view ->
            imgIcon9.startAnimation(anim3)
        }
        btnUpdownCancel.setOnClickListener { view ->
            finish()
        }
        btnUpdownRetry.setOnClickListener { view ->
            toast("재도전 합니다. ")
            count=6
            num = random.nextInt(101)
            txtUpdownResult.setText("게임을 재시작합니다. 남은횟수 : 6")
            imgUpdownResult.setImageResource(R.drawable.questionicon)
        }
        btnUpdownAnswer.setOnClickListener { view ->
            if (count == 0) {
                txtUpdownResult.setText("게임이 이미 종료되었습니다. ")
                toast("더하고 싶다면 재도전을 눌러주세요")
            }
            else {
                count = count - 1
                try {
                    usernum = edtUpdownNumber.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    usernum = -1234123123
                    toast("숫자입력하지 않아서 횟수1을 차감합니다.")
                }
                if((count==0) &&usernum!=num){
                    txtUpdownResult.setText("게임 오버 지정된숫자 : "+num)
                    imgUpdownResult.setImageResource(R.drawable.xicon)
                    toast("6번안에 못맞추셨습니다.!! 게임 오버 더하고싶다면 재도전을.. ")
                }
                else if (usernum == -1234123123) {
                    imgUpdownResult.setImageResource(R.drawable.questionicon)
                    txtUpdownResult.setText("기회를 날렸습니다. 남은횟수 : " + count)
                } else if (usernum == num) {
                    imgUpdownResult.setImageResource(R.drawable.oicon)
                    txtUpdownResult.setText("축하합니다 정답입니다.")
                    toast("더하고 싶다면 재도전을 눌러주세요")
                    count=0
                }
                else if (usernum> num){
                    toast("down!")
                    txtUpdownResult.setText(""+usernum+" 보다 작음! 남은횟수 : "+count)
                    imgUpdownResult.setImageResource(R.drawable.updownicon2)
                }
                else {
                    toast("up!")
                    txtUpdownResult.setText(""+usernum+" 보다 큼! 남은횟수 : "+count)
                    imgUpdownResult.setImageResource(R.drawable.updownicon)
                }
            }
        }
    }
}
