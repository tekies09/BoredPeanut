package com.moontek.peanuts

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.item.view.*

class ListTextAdapter (val context: Context, val listText:List<textUser>): BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = View.inflate(context, R.layout.item, null)
        rowView.txtText.text=listText[p0].text.toString()
        rowView.imgDelete.setOnClickListener {
            val firebaseDatabase = FirebaseDatabase.getInstance()
            var databaseReference = firebaseDatabase.getReference("test")
            databaseReference.child(listText[p0].key.toString()).removeValue().addOnCompleteListener{
                Toast.makeText(context,"삭제됨",Toast.LENGTH_SHORT).show()
            }
        }
        return rowView
         }

    override fun getItem(p0: Int): Any {
    return listText[p0]
   }

    override fun getItemId(p0: Int): Long {
   return 0
    }

    override fun getCount(): Int {
     return listText.size
    }

}