package com.moontek.peanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diary_edit.*
import java.util.*

class DiaryEditActivity : AppCompatActivity() {
    val calendar: Calendar = Calendar.getInstance()
    val myDb:MyDBHeleper= MyDBHeleper(this)
    var mode:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_edit)
        val todo= intent.getSerializableExtra("todo")
        if(todo!=null){
            todo as Todo
            edtDiaryTitle.setText(todo.title)
            edtDiaryMessage.setText(todo.message)
            calendarView.date=todo.writedate
            mode=1
        }
        calendarView.setOnDateChangeListener{ view , year , month ,dayOfMonth->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
        }
        fab_DiaryAdd.setOnClickListener { view ->
            val title =edtDiaryTitle.text.toString()
            val message= edtDiaryMessage.text.toString()
            val writedate= calendar.timeInMillis
            val todo= Todo(title,message,writedate)
            if(mode==0){
                myDb.addTodo(todo)
            } else if(mode==1){
                myDb.updateTodo(todo)
            }
            val intent = Intent(this,DiaryActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        fab_DiaryDelete.setOnClickListener { view ->
            val title =edtDiaryTitle.text.toString()
            val message= edtDiaryMessage.text.toString()
            val writedate= calendar.timeInMillis
            val todo= Todo(title,message,writedate)
            myDb.deleteTodo(todo)

            val intent = Intent(this,DiaryActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}
