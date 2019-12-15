package com.moontek.peanuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_internet.*

class InternetFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_internet, null)
         var mwebview = view.findViewById<WebView>(R.id.webView1)
        var btnMovingUrl = view.findViewById<Button>(R.id.btnMoveUrl)
        var btnPretingUrl = view.findViewById<Button>(R.id.btnPretUrl)
        var EdtUrl = view.findViewById<EditText>(R.id.edtUrl)
        mwebview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        btnMovingUrl.setOnClickListener { view ->
        mwebview.loadUrl(EdtUrl.text.toString())
        }
        btnPretingUrl.setOnClickListener { view ->
            mwebview.goBack()
        }
        mwebview.loadUrl("https://www.naver.com")

        // 처리
        return view
    }
}

