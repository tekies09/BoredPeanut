package com.moontek.peanuts

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHeleper(context:Context): SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VER) {

    companion object{
        private val DATABASE_NAME="todo.db"
        private val DATABASE_VER=1
        private val TABLE_NAME ="todo"
    }
    override fun onCreate(p0: SQLiteDatabase?) {
       p0!!.execSQL("create table $TABLE_NAME(id integer primary key autoincrement, title text, message String, writedate long)")
        }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
      p0!!.execSQL("drop table if exists $TABLE_NAME")
        onCreate(p0!!)
       }
    fun allTodo():List<Todo>{
        val listTodo=ArrayList<Todo>()
        val sql ="select * from $TABLE_NAME"
        val db= this.writableDatabase
        val cursor = db.rawQuery(sql,null)
        if(cursor.moveToFirst()){
            do{
                val todo= Todo()
                todo.title=cursor.getString(1)
                todo.message= cursor.getString(2)
                todo.writedate= cursor.getLong(3)
                listTodo.add(todo)
            }
            while (cursor.moveToNext())
        }
        db.close()
        return listTodo
    }
    fun addTodo(todo:Todo){
        val db= this.writableDatabase
        val values= ContentValues()
        values.put("title", todo.title)
        values.put("message", todo.message)
        values.put("writedate",todo.writedate)
        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    fun updateTodo(todo:Todo){
        val db= this.writableDatabase
        val values= ContentValues()
        values.put("title", todo.title)
        values.put("message", todo.message)
        values.put("writedate",todo.writedate)
        db.update(TABLE_NAME,values,"title=?", arrayOf(todo.title))
        db.close()
    }
    fun deleteTodo(todo:Todo){
        val db=this.writableDatabase
        db.delete(TABLE_NAME,"title=?", arrayOf(todo.title))
        db.close()
    }
}