package com.moontek.peanuts
import android.app.Application
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class ChatFragment: Fragment() {
    var firebaseAuth = FirebaseAuth.getInstance()
    var firebaseDatabase =FirebaseDatabase.getInstance()
    var databaseReference = firebaseDatabase.getReference("test")
    var arrayText = ArrayList<textUser>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chat, null)
        // 처리
        var adapter = ListTextAdapter(view.context,arrayText)
        var listContents = view.findViewById<ListView>(R.id.listContent)
        var btnInput = view.findViewById<Button>(R.id.btnTextSend)
        var edtText = view.findViewById<EditText>(R.id.edtTextSend)
        val random = Random()
        val NameList: Array<String> = arrayOf("행복한 바지","슬픈 바지","화난 바지","옆집아저씨","옆집강아지","옆집고양이","피로에찌든직장인",
            "체리에이드","휘핑없는핫초코","다이어트코카콜라","민트야사랑해")
        listContents.adapter=adapter

        val user = firebaseAuth.currentUser
        btnInput.setOnClickListener {
            val num = random.nextInt(11)
            val ref = databaseReference.push()
            var key= ref.key
            var email = user!!.email.toString()
            var text = NameList[num]+"의 외침 \n"+edtText.text.toString()
            var userText = textUser(key,email,text)
            ref.setValue(userText)
            edtText.setText("")
        }

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
               }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                adapter!!.notifyDataSetChanged()
                arrayText.clear()
                adapter!!.notifyDataSetChanged()
                for(messageData in dataSnapshot.children){
                    val post:textUser = messageData.getValue(textUser::class.java) as textUser
                    arrayText.add(post)
                    adapter!!.notifyDataSetChanged()
                }
            }
        })
        return view
    }
}