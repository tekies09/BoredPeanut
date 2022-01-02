package com.moontek.peanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_food.*
import java.util.*

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val random = Random()

        var anim2 = AnimationUtils.loadAnimation(applicationContext,R.anim.scale1_anim)
        var anim1 = AnimationUtils.loadAnimation(applicationContext,R.anim.alpha1_anim)
        var anim3 = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anim)
        var FoodList = mutableListOf<String>("없습니다. 다이어트하세요")
        imgIcon9.setOnClickListener { view ->
            imgIcon9.startAnimation(anim3)
        }
        btnFoodCancel.setOnClickListener { view ->
            finish()
        }
        btnFoodSelect.setOnClickListener { view ->
            FoodList.clear()
            FoodList.add("오늘은 먹지 않습니다. 다이어트하세요")
            if(chkFood1.isChecked){
                FoodList.add("짜장면")
            }
            if(chkFood2.isChecked){
                FoodList.add("짬뽕")
            }
            if(chkFood3.isChecked){
                FoodList.add("라면")
            }
            if(chkFood4.isChecked){
                FoodList.add("까르보나라")
            }
            if(chkFood5.isChecked){
                FoodList.add("회덮밥")
            }
            if(chkFood6.isChecked){
                FoodList.add("가츠동")
            }
            if(chkFood7.isChecked){
                FoodList.add("스테이크")
            }
            if(chkFood8.isChecked){
                FoodList.add("갈비찜")
            }
            if(chkFood9.isChecked){
                FoodList.add("닭발")
            }
            if(chkFood10.isChecked){
                FoodList.add("냉면")
            }
            if(chkFood11.isChecked){
                FoodList.add("치킨")
            }
            if(chkFood12.isChecked){
                FoodList.add("족발")
            }
            if(chkFood13.isChecked){
                FoodList.add("보쌈")
            }
            var number = FoodList.size
            var Rannum = random.nextInt(number)
            if(Rannum==0){
                txtFoodResult.setText(FoodList.get(Rannum))
                imgFood2.setImageResource(R.drawable.xicon)
            }
            else {
                txtFoodResult.setText("오늘의 음식은 : " +FoodList.get(Rannum))
                imgFood2.setImageResource(R.drawable.foodicon)
            }

        }
        btnFoodRetry.setOnClickListener { view ->
            chkFood1.isChecked=false
            chkFood2.isChecked=false
            chkFood3.isChecked=false
            chkFood4.isChecked=false
            chkFood5.isChecked=false
            chkFood6.isChecked=false
            chkFood7.isChecked=false
            chkFood8.isChecked=false
            chkFood9.isChecked=false
            chkFood10.isChecked=false
            chkFood11.isChecked=false
            chkFood12.isChecked=false
            chkFood13.isChecked=false
            txtFoodResult.setText("오늘은 무엇을 먹을까요?")
            imgFood2.setImageResource(R.drawable.foodicon)
        }
    }
}
