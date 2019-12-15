package com.moontek.peanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diary.*

class DiaryActivity : AppCompatActivity() {
    var listTodo:List<Todo> = ArrayList()
    val myDb:MyDBHeleper= MyDBHeleper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        listTodo=myDb.allTodo()
        val adapter=ListTodoAdapter(this,listTodo)
        DiaryListView.adapter=adapter
        fabDiary1.setOnClickListener{view ->
            finish()
        }
        fabDiary2.setOnClickListener { view ->
            val intent = Intent(this,DiaryEditActivity::class.java)
            startActivity(intent)
        }
        DiaryListView.setOnItemClickListener{adapterView, view, i, l ->
            val intent = Intent(this,DiaryEditActivity::class.java)
            intent.putExtra("todo",listTodo.get(i))
            startActivity(intent)}

    }
}
