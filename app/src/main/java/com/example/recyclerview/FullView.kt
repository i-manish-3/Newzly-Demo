package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_full_view.*

class FullView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_view)

        getSupportActionBar()?.hide()
        val url = intent.getStringExtra("URL")
        if(url!=null)
        {
            fullView.settings.javaScriptEnabled = true
            fullView.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36"
            fullView.webViewClient = object :WebViewClient()
            {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility = View.GONE
                    fullView.visibility = View.VISIBLE
                }
            }
            fullView.loadUrl(url)
        }
    }
}