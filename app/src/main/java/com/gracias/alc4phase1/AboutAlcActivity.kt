package com.gracias.alc4phase1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_alc.*
import android.net.ConnectivityManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import android.net.http.SslError
import android.webkit.SslErrorHandler




class AboutAlcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)

        val actionBar = supportActionBar
        val title = getString(R.string.about_alc);
        val url = getString(R.string.url);
        actionBar!!.title =title

        actionBar.setDisplayHomeAsUpEnabled(true)

        webview.apply {
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            webViewClient = object : WebViewClient() {
                override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                    handler.proceed()
                }
            }

        }

        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show()

        } else {
            webview.loadUrl(url)

        }

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
