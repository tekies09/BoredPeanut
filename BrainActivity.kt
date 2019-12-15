package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_brain.*
import org.jetbrains.anko.toast

class BrainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain)
        var anim2 = AnimationUtils.loadAnimation(applicationContext,R.anim.scale1_anim)
        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        var START_DRAG =0
        var END_DRAG=1
        var isMoving1:Int=-1; var isMoving2:Int=-1; var isMoving3:Int=-1; var isMoving4:Int=-1; var isMoving5:Int=-1;
        var offset_x1:Float=4.0f; var offset_y1:Float=4.0f;var offset_x2:Float=4.0f; var offset_y2:Float=4.0f;
        var offset_x3:Float=4.0f; var offset_y3:Float=4.0f;var offset_x4:Float=4.0f; var offset_y4:Float=4.0f;
        var offset_x5:Float=4.0f; var offset_y5:Float=4.0f;
        var start_yn1=true;var start_yn2=true;var start_yn3=true;var start_yn4=true;var start_yn5=true;
        var checkcount1 = 0; var checkcount2 = 0; var checkcount3 = 0; var checkcount4 = 0; var checkcount5 = 0;
        var firstoffset_x1:Float=4.0f;var firstoffset_y1:Float=4.0f;var firstoffset_x2:Float=4.0f;var firstoffset_y2:Float=4.0f;
        var firstoffset_x3:Float=4.0f;var firstoffset_y3:Float=4.0f;var firstoffset_x4:Float=4.0f;var firstoffset_y4:Float=4.0f;
        var firstoffset_x5:Float=4.0f;var firstoffset_y5:Float=4.0f;

        btnSheep.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
           if(event?.action==MotionEvent.ACTION_DOWN)
           {
               isMoving1=START_DRAG
               if(start_yn1){
                   offset_x1=event.x
                   offset_y1=event.y
                   start_yn1=false
               }
           }
                else if (event?.action==MotionEvent.ACTION_UP)
           {
               isMoving1=END_DRAG
           }
                else if (event?.action==MotionEvent.ACTION_MOVE)
           {
               if(isMoving1==START_DRAG){
                    v?.x=event.rawX-offset_x1
                    v?.y=event.rawY-offset_y1
                   if(checkcount1==0){
                       firstoffset_x1=event.rawX-offset_x1
                       firstoffset_y1=event.rawY-offset_y1
                       checkcount1=checkcount1+1
                   }
               }
           }
                return v?.onTouchEvent(event) ?:true
            }
        })

        btnCow.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action==MotionEvent.ACTION_DOWN)
                {
                    isMoving2=START_DRAG
                    if(start_yn2){
                        offset_x2=event.x
                        offset_y2=event.y
                        start_yn2=false
                    }
                }
                else if (event?.action==MotionEvent.ACTION_UP)
                {
                    isMoving2=END_DRAG
                }
                else if (event?.action==MotionEvent.ACTION_MOVE)
                {
                    if(isMoving2==START_DRAG){
                        v?.x=event.rawX-offset_x2
                        v?.y=event.rawY-offset_y2
                        if(checkcount2==0){
                            firstoffset_x2=event.rawX-offset_x2
                            firstoffset_y2=event.rawY-offset_y2
                            checkcount2=checkcount2+1
                        }
                    }
                }
                return v?.onTouchEvent(event) ?:true
            }
        })
        btnMonkey.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action==MotionEvent.ACTION_DOWN)
                {
                    isMoving3=START_DRAG
                    if(start_yn3){
                        offset_x3=event.x
                        offset_y3=event.y
                        start_yn3=false
                    }
                }
                else if (event?.action==MotionEvent.ACTION_UP)
                {
                    isMoving3=END_DRAG
                }
                else if (event?.action==MotionEvent.ACTION_MOVE)
                {
                    if(isMoving3==START_DRAG){
                        v?.x=event.rawX-offset_x3
                        v?.y=event.rawY-offset_y3
                        if(checkcount3==0){
                            firstoffset_x3=event.rawX-offset_x3
                            firstoffset_y3=event.rawY-offset_y3
                            checkcount3=checkcount3+1
                        }
                    }
                }
                return v?.onTouchEvent(event) ?:true
            }
        })
        btnLion.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action==MotionEvent.ACTION_DOWN)
                {
                    isMoving4=START_DRAG
                    if(start_yn4){
                        offset_x4=event.x
                        offset_y4=event.y
                        start_yn4=false
                    }
                }
                else if (event?.action==MotionEvent.ACTION_UP)
                {
                    isMoving4=END_DRAG
                }
                else if (event?.action==MotionEvent.ACTION_MOVE)
                {
                    if(isMoving4==START_DRAG){
                        v?.x=event.rawX-offset_x4
                        v?.y=event.rawY-offset_y4
                        if(checkcount4==0){
                            firstoffset_x4=event.rawX-offset_x4
                            firstoffset_y4=event.rawY-offset_y4
                            checkcount4=checkcount4+1
                        }
                    }
                }
                return v?.onTouchEvent(event) ?:true
            }
        })
        btnHorse.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action==MotionEvent.ACTION_DOWN)
                {
                    isMoving5=START_DRAG
                    if(start_yn5){
                        offset_x5=event.x
                        offset_y5=event.y
                        start_yn5=false
                    }
                }
                else if (event?.action==MotionEvent.ACTION_UP)
                {
                    isMoving5=END_DRAG
                }
                else if (event?.action==MotionEvent.ACTION_MOVE)
                {
                    if(isMoving5==START_DRAG){
                        v?.x=event.rawX-offset_x5
                        v?.y=event.rawY-offset_y5
                        if(checkcount5==0){
                            firstoffset_x5=event.rawX-offset_x5
                            firstoffset_y5=event.rawY-offset_y5
                            checkcount5=checkcount5+1
                        }
                    }
                }
                return v?.onTouchEvent(event) ?:true
            }
        })
        imgIcon12.setOnClickListener { view ->
            imgIcon12.startAnimation(anim3)
        }
        btnBrainCancel.setOnClickListener { view ->
            finish()
        }
        btnBrainRetry.setOnClickListener { view ->
           txtBrainResult.setText("당신은 동물들과 사막을 5일동안 여행을 떠납니다. \n사막여행이 힘들었던 나머지 하루에 한마리씩 버릴려고합니다.\n 동물들은 다음과 같습니다. \n커다란 암소 , 털이긴 원숭이 ,얌전한 양 , 젊은 말 , 용맹한 사자 " +
                   "\n 마지막 날에는 목적지에 도착하며 동물1마리가 남습니다.\n 몇일차에 어떤동물을 버릴것이며 \n어떤동물을 끝까지 가져갈지 선택해주세요.")
            txtBrainFirst.setText("1일차")
            txtBrainSecond.setText("2일차")
            txtBrainThird.setText("3일차")
            txtBrainForth.setText("4일차")
            txtBrainFinal.setText("최종")
            btnSheep.setText("양")
            btnCow.setText("암소")
            btnHorse.setText("말")
            btnMonkey.setText("원숭이")
            btnLion.setText("사자")
            imgBrain2.setImageResource(R.drawable.brainicon)
            if(checkcount1!=0) {
                btnSheep.x = firstoffset_x1
                btnSheep.y = firstoffset_y1
            }
            if(checkcount2!=0) {
                btnCow.x = firstoffset_x2
                btnCow.y = firstoffset_y2
            }
            if(checkcount3!=0) {
                btnMonkey.x = firstoffset_x3
                btnMonkey.y = firstoffset_y3
            }
            if(checkcount4!=0) {
                btnLion.x = firstoffset_x4
                btnLion.y = firstoffset_y4
            }
            if(checkcount5!=0) {
                btnHorse.x = firstoffset_x5
                btnHorse.y = firstoffset_y5
            }
        }
        btnBrainSelect.setOnClickListener { view ->
           txtBrainResult.setText("심리테스트 결과는 다음과 같습니다. \n 본인이 안좋은 위기를 겪었을때 \n가장 먼저 포기하게 되는 순위입니다. \n" +
                   "당신이 끝까지 지킬것은 무엇인가요?? ")
            txtBrainFirst.setText("1순위")
            txtBrainSecond.setText("2순위")
            txtBrainThird.setText("3순위")
            txtBrainForth.setText("4순위")
            txtBrainFinal.setText("5순위")
            btnSheep.setText("사랑")
            btnCow.setText("일")
            btnHorse.setText("가족")
            btnMonkey.setText("친구")
            btnLion.setText("자존심")
            imgBrain2.setImageResource(R.drawable.iconoutline)
        }
    }

}
