package com.moontek.peanuts

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item2.view.*
import java.text.SimpleDateFormat
import java.util.zip.DataFormatException

class ListTodoAdapter(val context:Context, val listTodo:List<Todo>): BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
     val rowView = View.inflate(context,R.layout.item2,null)
        rowView.txtitem2Title.text=listTodo[p0].title.toString()+":"+listTodo[p0].message.toString()
        rowView.txtitem2Date.text=SimpleDateFormat("yyyy.MM.dd").format(listTodo[p0].writedate)
        return rowView
    }
    override fun getItem(p0: Int): Any {
      return listTodo[p0]  }

    override fun getItemId(p0: Int): Long {
      return 0  }

    override fun getCount(): Int {
        return listTodo.size }
}