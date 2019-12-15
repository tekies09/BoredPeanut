package com.moontek.peanuts

import android.app.AlertDialog
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer

class MainFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, null)
        var hometime = view.findViewById<TextView>(R.id.txtHomeTime)
        val timer = kotlin.concurrent.timer(period = 1000){
            var now1 = Date(System.currentTimeMillis())
            var now2= SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(now1)
            hometime.setText("현재시간 \n"+now2)
        }
        var btnvfstart = view.findViewById<Button>(R.id.btnHomeStart)
        var btnvfEnd = view.findViewById<Button>(R.id.btnHomeEnd)
        var btnvfPrev = view.findViewById<Button>(R.id.btnHomePrev)
        var btnvfNext = view.findViewById<Button>(R.id.btnHomeNext)
        var vfHomeFlipper = view.findViewById<ViewFlipper>(R.id.vfHome)

        vfHomeFlipper.flipInterval=2000
        vfHomeFlipper.startFlipping()

        btnvfstart.setOnClickListener { view ->
            vfHomeFlipper.startFlipping()
        }
        btnvfEnd.setOnClickListener { view ->
            vfHomeFlipper.stopFlipping()
        }
        btnvfPrev.setOnClickListener { view ->
            vfHomeFlipper.showPrevious()
        }
        btnvfNext.setOnClickListener { view ->
            vfHomeFlipper.showNext()
        }
        // 처리
        return view
    }
}

